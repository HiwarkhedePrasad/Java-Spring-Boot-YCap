package com.example.App;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class testController {
	@GetMapping("/run")
	public String run() {
		return "NewFile";
	}
	
	
	@GetMapping("/")
	public String hun() {
		return "welcome";
	}
	
	@PostMapping("/submit")
	public String submit(@RequestParam("name") String name,
	                     RedirectAttributes redirectAttributes) {

	    redirectAttributes.addFlashAttribute("name", name);
	    return "redirect:/test-success";
	}
	
	@GetMapping("/test-success")
	public String kun() {
		return "success";
	}

}



