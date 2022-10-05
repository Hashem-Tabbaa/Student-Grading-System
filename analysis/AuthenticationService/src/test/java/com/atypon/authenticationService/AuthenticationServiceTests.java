package com.atypon.authenticationService;


import com.atypon.authenticationService.controller.AuthenticationController;
import com.atypon.authenticationService.model.User;
import com.atypon.authenticationService.service.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthenticationServiceTests {

    @Test
    public void contextLoads() {
        User user = new User("admin", "admin");

        AuthenticationController authenticationController = new AuthenticationController(
                new AuthenticationService()
        );

        assert authenticationController.authenticate(user) == true;
    }

}
