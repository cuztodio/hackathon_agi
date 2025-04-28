package com.agibank.hackathon.ems.entity;

import com.agibank.hackathon.ems.enums.StatusDesligamento;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.Date;

@Builder
@Data
public class Desligamento {
    @Id
    private String cpf;
    private boolean desligado;
    private Date dataDesligamento;
}
