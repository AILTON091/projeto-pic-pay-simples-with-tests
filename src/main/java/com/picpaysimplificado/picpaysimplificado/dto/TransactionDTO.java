package com.picpaysimplificado.picpaysimplificado.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TransactionDTO {
    private BigDecimal value;
    private Long receiverId;
    private Long senderId;

}
