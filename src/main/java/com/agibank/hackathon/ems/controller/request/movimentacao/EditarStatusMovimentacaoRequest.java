package com.agibank.hackathon.ems.controller.request.movimentacao;

import com.agibank.hackathon.ems.enums.StatusMovimentacao;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditarStatusMovimentacaoRequest {

    private StatusMovimentacao movimentacao;
}