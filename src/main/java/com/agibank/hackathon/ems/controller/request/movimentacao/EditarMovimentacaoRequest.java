package com.agibank.hackathon.ems.controller.request.movimentacao;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EditarMovimentacaoRequest {

    private String employeeId;

    private String equipmentId;

    private LocalDateTime dataMovimentacao;
}