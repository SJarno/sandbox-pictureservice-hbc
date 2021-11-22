package com.jarno.pictureservice.controllers;

import com.jarno.pictureservice.repositories.ImageObjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @Autowired
    private ImageObjectRepository iRepository;

    @GetMapping("/")
    public String home(Model model) {
        
        return "redirect:/index";
        
    }
    @GetMapping("/index")
    public String index(Model model) {
        
        return "index";
    }
    @GetMapping("/thyme-test")
    public String thymeTest(Model model) {
        model.addAttribute("images", iRepository.findAll());
        return "thyme-test";
    }
    
    
}
