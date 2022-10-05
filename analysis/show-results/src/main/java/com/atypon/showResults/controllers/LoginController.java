package com.atypon.showResults.controllers;

import com.atypon.showResults.model.User;
import com.atypon.showResults.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(User user, HttpServletRequest request){
        System.out.println("Validating the user");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        //if valid user then redirect to enterData page
        if(loginService.validateUser(user)){
            request.getSession().setAttribute("username", user.getUsername());
            return "redirect:/results";
        }
        //redirect to login page with error message
        return "login";
    }


}
