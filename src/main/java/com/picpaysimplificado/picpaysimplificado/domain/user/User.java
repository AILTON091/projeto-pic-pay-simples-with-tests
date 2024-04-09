package com.picpaysimplificado.picpaysimplificado.domain.user;


import com.picpaysimplificado.picpaysimplificado.dto.UserDTO;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType type;

    public User(UserDTO userDTO){
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.document = userDTO.getDocument();
        this.balance = userDTO.getBalance();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.type = userDTO.getType();
    }
}
