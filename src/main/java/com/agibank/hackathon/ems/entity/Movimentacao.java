package com.agibank.hackathon.ems.entity;

import com.agibank.hackathon.ems.enums.StatusMovimentacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@Document(collection = "Movimentacoes")
public class Movimentacao {

    @Id
    private String id;

    @NotBlank
    private String funcionarioId;

    @NotBlank
    private String equipamentoId;

    @PastOrPresent
    private LocalDateTime dataMovimentacao;

    private StatusMovimentacao statusMovimentacao;
}
