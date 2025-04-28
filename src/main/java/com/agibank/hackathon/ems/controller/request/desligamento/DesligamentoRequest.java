package com.agibank.hackathon.ems.controller.request.desligamento;

import com.agibank.hackathon.ems.enums.StatusDesligamento;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DesligamentoRequest {
    private StatusDesligamento status;
    private String idFuncionario;
}