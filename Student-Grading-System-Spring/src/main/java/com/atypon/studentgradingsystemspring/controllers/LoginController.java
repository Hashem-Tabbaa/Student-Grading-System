package com.atypon.studentgradingsystemspring.controllers;

import com.atypon.studentgradingsystemspring.model.StudentsCourses;
import com.atypon.studentgradingsystemspring.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        if(request.getSession().getAttribute("username") != null){
            return "redirect:/home";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpServletRequest request){
        System.out.println("Post login");
        System.out.println(username + " " + password);
        if(loginService.validate(username, password)){
            request.getSession().setAttribute("username", username);
            return "redirect:/home";
        }
        request.setAttribute("error", "Invalid username or password");
        return "redirect:/login";
    }

}
