package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.BillHoa;
import com.example.demo.entity.Cart;
import com.example.demo.entity.ChuDeHoas;
import com.example.demo.entity.Hoa;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.OrderDetailId;
import com.example.demo.entity.User;
import com.example.demo.service.ICartService;
import com.example.demo.service.IChuDeHoaService;
import com.example.demo.service.IHoaService;
import com.example.demo.service.IOrderDetailservice;
import com.example.demo.service.IOrderService;
import com.example.demo.service.IUserService;
import com.example.demo.utility.CommonConst;



@Controller
@RequestMapping("/shop")
public class ShopController {
	@Autowired private IHoaService hoaService;
	@Autowired private ICartService cartService;
	@Autowired private IChuDeHoaService chuDeHoaService;
	@Autowired private IOrderService orderService;
	@Autowired private IOrderDetailservice orderDetailservice;
	@Autowired private IUserService UserService;

	@GetMapping
	public String getAlll(Model model, @RequestParam(name = "pageNumber", defaultValue = "0")int pageNumber ) {
		List<ChuDeHoas> chuDeHoa = chuDeHoaService.getAll();
		model.addAttribute("chuDeHoa",chuDeHoa);
		Page<Hoa> hoaPage = hoaService.getByPage(pageNumber, CommonConst.PAGE_SIZE);
		model.addAttribute("page", hoaPage);
		model.addAttribute("view", "shop/show.jsp");
		return "index";	
	}
	
	
	@GetMapping("/hoadon")
	public String getHoaDon(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User buyer = (User) session.getAttribute("user");
		int id = buyer.getIdUser();
		List<OrderDetail> orderDetails = orderDetailservice.getHoaDon(id);
		model.addAttribute("hd",orderDetails);
		return "shop/hoadon";
	}
	@GetMapping("/qlhoadon")
	public String getqlHoaDon(Model model, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		User buyer = (User) session.getAttribute("user");
//		int id = buyer.getIdUser();
		List<OrderDetail> orderDetails = orderDetailservice.getAll();
		model.addAttribute("hd",orderDetails);
		return "shop/order";
	}
	
	 @GetMapping("/delete")
	 public String delete(@RequestParam("id") Integer id,Model model, Order order) {
		 Order order2 = orderService.finById(id);
		 order2.setRole(3);
		 orderService.saveOrder(order2);
		 return "redirect:/shop/hoadon";
	 }
	 @GetMapping("/delete2")
	 public String delete2(@RequestParam("id") Integer id,Model model, Order order) {
		 Order order2 = orderService.finById(id);
		 order2.setRole(3);
		 orderService.saveOrder(order2);
		 return "redirect:/shop/qlhoadon";
	 }
	 @GetMapping("/delete3")
	 public String delete3(@RequestParam("id") Integer id,Model model, Order order) {
		 Order order2 = orderService.finById(id);
		 order2.setRole(2);
		 orderService.saveOrder(order2);
		 // gửi email
		// User user = UserService.finByEmail(null)
		 
		 return "redirect:/shop/qlhoadon";
	 }
	
	@GetMapping("/xem/{hoaId}")
	public String getHoa(Model model, @PathVariable Integer hoaId) {
		List<ChuDeHoas> chuDeHoa = chuDeHoaService.getAll();
		model.addAttribute("chuDeHoa",chuDeHoa);
		Hoa hoa = hoaService.finById(hoaId);
		model.addAttribute("hoa", hoa);
		//model.addAttribute("view", "shop/showmua.jsp");
		return "shop/showmua";	
	}
	
	@GetMapping("/cart")
	public String showCart(Model model) {
		Collection<BillHoa> billHoas = cartService.getCart();
		
		model.addAttribute( "billHoas",billHoas);
		model.addAttribute("NoOfItem", cartService.GetCount());
		return "shop/cart";
	}
//	@GetMapping("/cart/{hoaId}")
//	public String addToCart(Model model, @PathVariable int hoaId) {
//		cartService.addToCart(hoaId, 1);
//		 Optional<Hoa> hoa = hoaService.findHoaById(hoaId);
//		model.addAttribute("cartDetails", cartService.getCart().getCartDetails());
//		model.addAttribute("hoa",hoa);
//		return "shop/cart";
//	}
	@GetMapping("/add/{hoaId}")
	public String addToCart(Model model, @PathVariable Integer hoaId, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		Hoa hoa = hoaService.finById(hoaId);
		if (hoa != null) {
			BillHoa billHoa = new BillHoa();
			billHoa.setHoaId(hoaId);
			billHoa.setHoa(hoa);
			billHoa.setGia(hoa.getGia());
			billHoa.setSoLuong(1);
			billHoa.setHoa(hoa);
			cartService.add(billHoa);
			model.addAttribute( "billHoas",billHoa);
		}
		return "redirect:/shop/cart";
	}
	
	@GetMapping("/showmua")
	public String showMua(Model model) {
		List<Hoa> hoa = hoaService.getAll();
		model.addAttribute("hoa",hoa);
		
		return "shop/showmua";
	}
	@PostMapping("/testmua")
	public String showMua(OrderDetail orderDetail) {
		
		orderDetailservice.saveOrderDetail(orderDetail);
		return "shop/showmua";
	}

	@GetMapping("/mua/{hoaId}")
	public String mua(Model model, HttpServletRequest request, @PathVariable Integer hoaId) {  
		
		  HttpSession session = request.getSession();
		  if (session.getAttribute("user") == null) {
			  session.setAttribute("error", "Bạn chưa đăng nhập!");
			  return "redirect:/user/dangnhap";
		}
		  User buyer = (User) session.getAttribute("user");
		  int id = buyer.getIdUser();
				  
		  Order order = new Order();
		  order.setCustomerId(id);
		  Date date = new Date();
		  order.setCreateDate(date);
		  //orderService.saveOrder(order);	
		  
		  BillHoa billHoas = cartService.finCart2(hoaId);
		  Hoa hoa = hoaService.finById(hoaId);
		  OrderDetail orderDetail = new OrderDetail();
		  orderDetail.setHoas(hoa);
		  orderDetail.setOrders(order);
		  orderDetail.setPurchasedQuantity(billHoas.getSoLuong());
		  //orderDetailservice.saveOrderDetail(orderDetail);
		  
		  int newSoluong = hoa.getSoLuong() - billHoas.getSoLuong();	  
		  if(newSoluong < 0) {
			  session.setAttribute("error", "Đặt hàng thất bại!");
			  return "redirect:/shop/cart";
		  } else {
			  hoa.setSoLuong(newSoluong);
			  order.setRole(1);
			  orderService.saveOrder(order);	
			  hoaService.saveHoa(hoa);
			  orderDetailservice.saveOrderDetail(orderDetail);
			  cartService.remove(hoaId);
			  session.setAttribute("message", "Đặt hàng thành công!");

			  return "redirect:/shop/cart";  
		  }
		  
		 
	}
//	@PutMapping("/update/{hoaId}")
//	  public Hoa updateSoluong(@PathVariable Integer id) {
//			Hoa x = new Hoa();
//			x.setId(id);
//			x.setTen("Hoa Huong Huy");
//			x.setType(HoaType.Type1);
//			return reponsitory.save(x);
//	  }
//	@GetMapping("/xem/{hoaId}")
//	public String xemHoa(Model model, @PathVariable Integer hoaId) {
//		Hoa hoa = hoaService.finById(hoaId);
//		model.addAttribute("xemHoa",hoa);
//		return "redirect:/shop";
//	}
	
	
//	@GetMapping("/showcart")
//	public String showCart(Model model) {
//		HttpServletRequest request;
//		request.getSession().setAttribute("hoa", cartService.getCart());
//		Cart cart = new Cart();
//		
//		// Optional<Hoa> hoa = hoaService.findHoaById(hoaId);
//		//model.addAttribute("cartDetails", cartService.getCart().getCartDetails());
//		//model.addAttribute("hoa",hoa);
//		return "shop/cart";
//	}
	
	
	@GetMapping("/delete/{hoaId}")
	public String delete(@PathVariable int hoaId,Model model) {
		 cartService.remove(hoaId);
		 return "redirect:/shop/cart";
	 }
	
	@PostMapping("/update")
	public String update(@RequestParam("hoaId") Integer hoaId, @RequestParam("soLuong") Integer soLuong) {
		cartService.update(hoaId, soLuong);
		return "redirect:/shop/cart";
	}
	
	
}
