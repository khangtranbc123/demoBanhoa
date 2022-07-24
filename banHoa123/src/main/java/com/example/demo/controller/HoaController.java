package com.example.demo.controller;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.ChuDeHoas;
import com.example.demo.entity.Hoa;
import com.example.demo.repository.IHoaRepository;
import com.example.demo.service.IChuDeHoaService;
import com.example.demo.service.IHoaService;
import com.example.demo.utility.CommonConst;

@Controller
@RequestMapping("/hoa")
public class HoaController {
	
	@Autowired(required = false)
	private IHoaService hoaService;
	@Autowired
	private IChuDeHoaService chuDeHoaService;
	
	
	@GetMapping
	public String getAlll(Model model, @RequestParam(name = "pageNumber", defaultValue = "0")int pageNumber ) {
		List<ChuDeHoas> chuDeHoa = chuDeHoaService.getAll();
		model.addAttribute("chuDeHoa",chuDeHoa);
		Page<Hoa> hoaPage = hoaService.getByPage(pageNumber, CommonConst.PAGE_SIZE);
		model.addAttribute("page", hoaPage);
		return "hoa/list";	
	}
	@GetMapping("/fin")
	public String finTheoChuDe(Model model, @RequestParam(name = "pageNumber", defaultValue = "0")int pageNumber,@RequestParam("tenChuDeHoa") String tenChuDeHoa ) {
		List<ChuDeHoas> chuDeHoa = chuDeHoaService.getAll();
		model.addAttribute("chuDeHoa",chuDeHoa);
		Page<Hoa> hoaPage = hoaService.finHoaTheoChuDe(tenChuDeHoa, pageNumber, CommonConst.PAGE_SIZE);
		model.addAttribute("page", hoaPage);
		return "hoa/list";	
		}
	
	@GetMapping("/finten")
	public String finTheoTen(Model model, @RequestParam(name = "pageNumber", defaultValue = "0")int pageNumber,@RequestParam("ten") String ten) {
		List<ChuDeHoas> chuDeHoa = chuDeHoaService.getAll();
		model.addAttribute("chuDeHoa",chuDeHoa);
		Page<Hoa> hoaPage = hoaService.finHoaTheoChuDe(ten, pageNumber, CommonConst.PAGE_SIZE);
		model.addAttribute("page", hoaPage);
		model.addAttribute("page", hoaPage);
		model.addAttribute("view", "shop/show.jsp");
		return "index";	
		}
	 
	 //@RequestMapping(value = "save", method = RequestMethod.POST)  
	 @PostMapping("/save")
	  public String save(Hoa hoa) {
		 
		 DateFormat df = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
		 Date date = new Date();
//		 String dateString = df.format(date);
//		 Date newDate  = df.parse(dateString);
		 hoa.setTrangThai(1);
		 hoa.setCreateDate(date);
		  hoaService.saveHoa(hoa);  
		  return "redirect:/hoa";
	  }
	 
	 
	 
	 @GetMapping("/delete")
	 public String delete(@RequestParam("id") Integer id,Model model, Hoa hoa) {
		 Hoa hoaDelete = hoaService.finById(id);
		 hoaDelete.setTrangThai(2);
		 hoaService.saveHoa(hoaDelete);
		 return "redirect:/hoa";
	 }
	 
	 @GetMapping("/edit")
	 public String edit(@RequestParam("id") Integer id, Model model) {
		 List<ChuDeHoas> chuDeHoa = chuDeHoaService.getAll();
		 model.addAttribute("chuDeHoa",chuDeHoa);
		 Optional<Hoa> hoaEdit = hoaService.findHoaById(id);
		 hoaEdit.ifPresent(hoa -> model.addAttribute("hoa", hoa));
		 return "hoa/edit";
	 }
	 
	 
	
	
	 
}
