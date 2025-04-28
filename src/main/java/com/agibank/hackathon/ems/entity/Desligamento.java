package com.agibank.hackathon.ems.entity;

import com.agibank.hackathon.ems.enums.StatusDesligamento;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Desligamento {
    @Id
    private String idFuncionario;
    private StatusDesligamento statusDesligamento;
    private date dataDesligamento;
}
