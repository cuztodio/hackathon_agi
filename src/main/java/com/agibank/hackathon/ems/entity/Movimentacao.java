package com.agibank.hackathon.ems.entity;

import com.agibank.hackathon.ems.enums.StatusMovimentacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Movimentacoes")
public class Movimentacao {

    @Id
    private String id;

    @NotBlank
    private String employeeId;

    @NotBlank
    private String equipmentId;

    @PastOrPresent
    private LocalDateTime dataMovimentacao;

    private StatusMovimentacao movimentacao;
}
