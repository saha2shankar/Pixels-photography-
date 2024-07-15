package com.pixels.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pixels.Service.MessagesService;
import com.pixels.models.Messages;

@Controller
public class HomepageController {
	@Autowired
	private MessagesService service;
	
	@GetMapping({"/","Home"})
	public String getHome() {
		return("index");
	}
	
	@GetMapping("/about")
	public String getAbout() {
		return"about";
	}
	
	@GetMapping("/contact")
	public String getContact() {
		return"contact";
	}
	

	@PostMapping("/contact")
	public String PostContact(@ModelAttribute Messages massages,Model model) {
		model.addAttribute("message","Your message has been sent. Thank you!");
		service.addmessge(massages);
		return"contact";
	}
	
	@GetMapping("/service")
	public String getService() {
		return"services";
	}
	
	@GetMapping("/resume")
	public String getResume() {
		return"resume";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return"AdminLogin";
	}
	

}
