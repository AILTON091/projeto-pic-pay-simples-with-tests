package com.picpaysimplificado.picpaysimplificado.services;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.picpaysimplificado.dto.TransactionDTO;
import com.picpaysimplificado.picpaysimplificado.repositories.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TransactionServiceTest {

    @Mock
    private TransactionRepository repository;
    @Mock
    private UserService userService;
    @Mock
    private NotificationService notificationService;
    @Mock
    private AuthorizationService authorizationService;

    @Autowired
    @InjectMocks // Injeta na classe transaction dados fictícios
    private TransactionService transactionService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this); // inicia os mocks
    }

    @Test
    @DisplayName("should create transaction successfully when everthing is OK")
    void createTransactionCase1() throws Exception {
        User sender = new User(1L, "Ana", "Julia", "9999999",
                "ana@gmail.com", "1234", new BigDecimal(10), UserType.COMMON);
        User receiver = new User(2L, "Joao", "Souza", "9999992",
                "joao@gmail.com", "12345", new BigDecimal(10), UserType.COMMON);

        when(userService.findUserById(1L)).thenReturn(sender);
        when(userService.findUserById(2L)).thenReturn(receiver);

        when(authorizationService.authorizeTranstion(any(), any())).thenReturn(true);

        TransactionDTO request = new TransactionDTO(new BigDecimal(10), 2L, 1L);
        transactionService.createTransaction(request);

        verify(repository, times(1)).save(any()); //verifica se a classe repository foi chamanda uma vez

        sender.setBalance(new BigDecimal(0)); // atualiza o balance do sender
        verify(userService, times(1)).saveUser(sender); // verifica se userService foi chamado 1 vez

        receiver.setBalance(new BigDecimal(20)); // atualiza o balance do recever
        verify(userService, times(1)).saveUser(receiver); // verifica se userService foi chamado 1 vez atualizando o receiver

        verify(notificationService, times(1)).sendNotification(sender, "Transação realizada com sucesso");
        verify(notificationService, times(1)).sendNotification(receiver, "Transação recebida com sucesso");
    }

    @Test
    @DisplayName("should throw exception when transction is not allowed")
    void createTransactionCase2(){

    }



}