package edu.miu.cs.lab10a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/elibrary", "/elibrary/home"})
    public String displayHomePage(Model model) {
        model.addAttribute("bannerText", "Vanessa's elibrary - My First Spring Boot Web Application");
        return "index";
    }
}