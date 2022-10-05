package com.atypon.authenticationService.service;

import com.atypon.authenticationService.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public Boolean authenticate(User user) {
        System.out.println("User: " + user.getUsername() + " Password: " + user.getPassword());
        return user.getUsername().equals("admin") && user.getPassword().equals("admin");
    }

}
