package com.spring_boot_initializer.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring_boot_initializer.demo.model.User;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@GetMapping("/register")
	public String showForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "register";
		}
		
		model.addAttribute("user", user);
		return "success";
	}
}
