package com.pixels.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pixels.Service.MessagesService;
import com.pixels.models.Messages;
import com.pixels.models.Users;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	private MessagesService service; 
	
	
	
	@GetMapping("/dashboard")
	public String getDashboard(@ModelAttribute Users users, Model model, HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"AdminLogin";
		}
		
		model.addAttribute("uname", users.getUsername());
		return"AdminDashboard";
	}

	@GetMapping("/message")
	public String getmessage(Model model, HttpSession session) {
		
		if(session.getAttribute("validuser")==null) {
			return"AdminLogin";
		}
		 // Fetch messages sorted by timestamp descending
        List<Messages> sortedMessages = service.getAllMessagesSortedByTimestampDesc();
        
        // Add sorted messages to the model
        model.addAttribute("messages", sortedMessages);
        
        return "Messages"; // Renders Messages.html template with messages data
	}
	
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return"index";
	}
	
}
