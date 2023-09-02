package com.example.weblor.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
	
	
	@GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Xin chào từ Thymeleaf!");
        return "main.html" ; // Tên của trang Thymeleaf template (ví dụ: hello.html).
    }

}
