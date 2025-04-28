package com.agibank.hackathon.ems.controller.request;
import com.agibank.hackathon.ems.enums.StatusFuncionario;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EditarStatusFuncionarioRequest {
    private StatusFuncionario status;
}
