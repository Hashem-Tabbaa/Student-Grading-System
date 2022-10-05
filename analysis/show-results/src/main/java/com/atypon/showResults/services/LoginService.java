package com.atypon.showResults.services;
import com.atypon.showResults.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

    public boolean validateUser(User user){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://authentication:8081/authenticate";
        String result = restTemplate.postForObject(url, user, String.class);

        return result.equals("true");
    }

}
