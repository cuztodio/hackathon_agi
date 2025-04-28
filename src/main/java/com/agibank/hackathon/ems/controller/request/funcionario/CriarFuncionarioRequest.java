package com.agibank.hackathon.ems.controller.request.funcionario;

import com.agibank.hackathon.ems.enums.StatusFuncionario;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
 public class CriarFuncionarioRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    private StatusFuncionario status;



}
