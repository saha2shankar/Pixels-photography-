package com.pixels.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.pixels.Service.UserService;
import com.pixels.models.Users;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/useradd")
	public String getuserAdd(HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"AdminLogin";
		}
		return"UserAdd";
	}
	
	@PostMapping("/useradd")
	public String getuserAdd(@ModelAttribute Users users ,Model model ,HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"AdminLogin";
		}
		service.adduser(users);
		model.addAttribute("message", "user added Successed !");
		return"UserAdd";
	}

	@GetMapping("/userview")
	public String getuserView(Model model, HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"AdminLogin";
		}
		model.addAttribute("users", service.getallUsers());
		return"Userview";
		
	}
	
	@GetMapping("/user/delete")
	public String deletUser(@RequestParam int id, HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"AdminLogin";
		}
		service.deleteuser(id);
		return"redirect:/userview";
	}
	
	@GetMapping("/user/edit")
	public String editUser(HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"AdminLogin";
		}
		return("edit");
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute Users users, Model model,HttpSession session) {
		Users u = service.login(users.getUsername(), users.getPassword());
		if(u !=null) {
			session.setAttribute("validuser", u);
			session.setMaxInactiveInterval(500);
			//model.addAttribute("uname", users.getUsername());
			return("AdminDashboard");
		}
		model.addAttribute("message", "user not find !");
		return("AdminLogin");
	}
	
	
}

