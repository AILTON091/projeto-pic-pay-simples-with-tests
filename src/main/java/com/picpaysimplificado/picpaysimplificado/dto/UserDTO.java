package com.picpaysimplificado.picpaysimplificado.dto;

import com.picpaysimplificado.picpaysimplificado.domain.user.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String document;
    private BigDecimal balance;
    private String email;
    private String password;
    private String type;
}
