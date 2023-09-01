package com.picpaysimplificado.picpaysimplificado.services;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.picpaysimplificado.dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.management.Notification;

@Service
public class NotificationService {
    @Value("${urlNotification}")
    private String urlNotification;
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

//        ResponseEntity<String> response = restTemplate.postForEntity(urlNotification, notificationRequest, String.class);
//        if(!(response.getStatusCode() == HttpStatus.OK)){
//            System.out.println("erro ao enviar notificacao");
//            throw new Exception("Serviço de notificação está fora do ar");
//        }
         System.out.println("Requisição enviada para o usuário");

    }
}
