package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;  

@Controller
public class HomeController {
   @GetMapping("/")
  public String home(Model model) {
       model.addAttribute("message", "Bem-vindo ao Spring MVC!");
       return "home"; // Nome do arquivo HTML na pasta templates
   } 

   @GetMapping("/user")
   public String user(Model model) {
       User user = new User();
       user.setName("João");
       user.setEmail("joao@email.com");  

       model.addAttribute("user", user);
       return "user"; // Nome do arquivo HTML na pasta templates
   }

   @GetMapping("/addUser")
   public String showForm(User user, Model model){
        model.addAttribute("user", new User());
        return "addUser";
   }

   @PostMapping("/addUser")
   public String submitForm(User user, Model model){
        model.addAttribute("user", user);
        return "user";
   }
}