package com.pixels.Controller;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.pixels.Service.PortfolioService;
import com.pixels.models.PortfolioDetail;

@Controller
public class uploadcontroller {
	
	@Autowired
	private PortfolioService service;

	  @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        binder.setDisallowedFields("image");
	    }
	
	@GetMapping("/upload")
	public String getupload() {
		return"UploadPortfolio";
	}
	
	@GetMapping("/gallery")
	public String getgallery(Model model) {
		model.addAttribute("portfolioList", service.getAllPortfolio());
		return"gallery";
	}
	
	
	@PostMapping("/upload")
	public String postupload(@ModelAttribute PortfolioDetail portfoliodetail, @RequestParam("image") MultipartFile image, Model model) {
		if (!image.isEmpty()) {
            try {
                // Ensure the directory exists
                Path directoryPath = Path.of("src/main/resources/static/image/");
                if (Files.notExists(directoryPath)) {
                    Files.createDirectories(directoryPath);
                }

                // Save the file
                Path filePath = directoryPath.resolve(image.getOriginalFilename());
                Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                // Set the file name in the student object
               
                portfoliodetail.setImage(image.getOriginalFilename());
        
                service.add(portfoliodetail);
                model.addAttribute("message", " Upload Success !");
                return "AdminDashboard";
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "File upload failed. Please try again.");
                return "AdminDashboard";  // Replace with your actual error page
            }
        } else {
        	 model.addAttribute("message", "Please select a file to upload.");
            return "AdminDashboard";  // Replace with your actual form page
        }
	}
}


