package com.picpaysimplificado.picpaysimplificado.services;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class AuthorizationService {

    @Value("${urlTransaction}")
    private String urlTransaction;

    @Autowired
    private RestTemplate restTemplate;

    public boolean authorizeTranstion(User sender, BigDecimal value){
        ResponseEntity<Map> authorizatoinResponse = restTemplate.getForEntity( urlTransaction, Map.class);

        if (authorizatoinResponse.getStatusCode() == HttpStatus.OK){
            String message = (String) authorizatoinResponse.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);
        }else return false;
    }


}
