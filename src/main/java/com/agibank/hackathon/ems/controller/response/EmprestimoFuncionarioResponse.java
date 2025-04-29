package com.agibank.hackathon.ems.controller.response;

import com.agibank.hackathon.ems.enums.StatusMovimentacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoFuncionarioResponse {
    private String id;
    private StatusMovimentacao statusMovimentacao;
}
