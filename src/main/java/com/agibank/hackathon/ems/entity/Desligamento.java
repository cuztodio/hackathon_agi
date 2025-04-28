package com.agibank.hackathon.ems.entity;

import com.agibank.hackathon.ems.enums.StatusDesligamento;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.Date;

@Data
public class Desligamento {
    @Id
    private String idFuncionario;
    private StatusDesligamento statusDesligamento;
    private Date dataDesligamento;
}
