package com.agibank.hackathon.ems.controller.request.movimentacao;

import com.agibank.hackathon.ems.enums.StatusMovimentacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CriarMovimentacaoRequest {

    @NotBlank
    private String employeeId;

    @NotBlank
    private String equipmentId;

    @PastOrPresent
    private LocalDateTime dataMovimentacao;

    private StatusMovimentacao movimentacao;
}