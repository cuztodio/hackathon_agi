package com.agibank.hackathon.ems.controller.request.funcionario;
import com.agibank.hackathon.ems.enums.StatusFuncionario;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SolicitarDesligamentoFuncionarioRequest {
    private StatusFuncionario status;


}
