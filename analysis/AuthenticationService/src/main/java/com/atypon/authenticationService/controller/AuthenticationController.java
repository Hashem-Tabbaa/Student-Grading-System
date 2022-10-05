package com.atypon.authenticationService.controller;


import com.atypon.authenticationService.model.User;
import com.atypon.authenticationService.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/authenticate")
    public Boolean authenticate(@RequestBody User user){
        System.out.println("Authenticating the user");
        return authenticationService.authenticate(user);
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
