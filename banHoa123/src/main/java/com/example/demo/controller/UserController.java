package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Hoa;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired IUserService UserService;
	
	@GetMapping("/kiemtra")
	public String dangnhap(Model model, @RequestParam(name = "email") String email, @RequestParam(name = "passWord") String passWord,HttpServletRequest request ) {
		HttpSession session = request.getSession();
		User user = UserService.finByEmail(email);
		String pass = user.getPassWord();
		
		int admin = 0;
		if (user==null) {
			session.setAttribute("error", "tài khoản không tồn tại!");
		}else {
			if (pass.equals(passWord)) {
				session.setAttribute("user", user);
				model.addAttribute("admin", admin);
				session.setAttribute("message", "Đăng nhập thành công!");
				return "redirect:/shop";
			}else {
				session.setAttribute("error", "Bạn nhập sai mật khẩu!");
			}
		}
		return "user/dangnhap";
	}
	
	@GetMapping("/dangnhap")
	public String dn() {
		return "user/dangnhap";
	}
	@GetMapping("/showdangky")
	public String dki() {
		return "user/dangky";
	}
	
	@GetMapping("/out")
	public String singOut(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.removeAttribute("user");
			session.invalidate();
		}
		return "redirect:/shop";
	}
	@PostMapping("/dangky")
	public String dangky(User user, HttpServletRequest request) {
		UserService.dangky(user);
		HttpSession session = request.getSession();
		session.setAttribute("error", "Đăng ký thành công!");
		return "redirect:/shop";
	}
}
