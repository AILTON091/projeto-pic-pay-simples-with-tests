package com.picpaysimplificado.picpaysimplificado.repositories;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.picpaysimplificado.dto.UserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // indíca para o spring q está classe é uma classe de teste e vai utilizar o JPA
@ActiveProfiles("test") // indica que é uma versão test
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityManager entityManager; // necessário para maniputar o banco de dados

    @Test
    @DisplayName("Should get User successfully from DB")
    void findUserByDocumentCase1() {
        String document = "999999901";
        UserDTO data = new UserDTO("João", "Vitor", document, new BigDecimal(10), "teste@teste.com", "1234", UserType.COMMON);
        this.createUser(data);

        Optional<User> result = this.userRepository.findUserByDocument(document);

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get User from DB when user not exist")
    void findUserByDocumentCase2() {
        String document = "999999901";

        Optional<User> result = this.userRepository.findUserByDocument(document);

        assertThat(result.isEmpty()).isTrue();
    }

    private User createUser(UserDTO data){
        User newUSer = new User(data);
        this.entityManager.persist(newUSer);
        return newUSer;
    }
}