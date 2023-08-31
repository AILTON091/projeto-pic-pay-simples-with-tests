package com.picpaysimplificado.picpaysimplificado.domain.repositories;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepositories extends JpaRepository<User,Long> {
    Optional<User> findUserByDocument(String document);
    Optional<User> findUserById(String document);
}
