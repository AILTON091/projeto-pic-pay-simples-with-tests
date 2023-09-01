package com.picpaysimplificado.picpaysimplificado.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDTO {
    private String message;
    private String status;
}
