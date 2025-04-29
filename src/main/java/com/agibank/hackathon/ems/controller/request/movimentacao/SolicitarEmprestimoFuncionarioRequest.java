package com.agibank.hackathon.ems.controller.request.movimentacao;

import com.agibank.hackathon.ems.enums.StatusMovimentacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SolicitarEmprestimoFuncionarioRequest {

    @NotBlank
    private String cpf;

    @NotBlank
    private String Sku;

    private LocalDateTime dataMovimentacao;

    private StatusMovimentacao movimentacao;

}
