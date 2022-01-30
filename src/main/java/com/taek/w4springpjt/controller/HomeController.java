package com.taek.w4springpjt.controller;

import com.taek.w4springpjt.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // @AuthenticationPrincipal UserDetailsImpl userDetails  가져오면 바로 /user/login 페이지로 간다.
        model.addAttribute("username", userDetails.getUsername());
        System.out.println("~~~homeController3");
        return "index";
    }
}
