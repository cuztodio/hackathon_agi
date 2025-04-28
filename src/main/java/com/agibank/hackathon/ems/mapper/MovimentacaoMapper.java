package com.agibank.hackathon.ems.mapper;

import com.agibank.hackathon.ems.controller.request.movimentacao.CriarMovimentacaoRequest;
import com.agibank.hackathon.ems.controller.request.movimentacao.EditarMovimentacaoRequest;
import com.agibank.hackathon.ems.entity.Movimentacao;
import com.agibank.hackathon.ems.enums.StatusMovimentacao;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class MovimentacaoMapper {

    public Movimentacao cadastroMovimentacao (@Valid CriarMovimentacaoRequest request){
        return Movimentacao.builder()
                .funcionarioId(request.getEmployeeId())
                .equipamentoId(request.getEquipmentId())
                .dataMovimentacao(request.getDataMovimentacao())
                .movimentacao(StatusMovimentacao.EMPRESTADO)
                .build();
    }

    public Movimentacao editarMovimentacao(String id, @Valid EditarMovimentacaoRequest request){
        return Movimentacao.builder()
                .id(id)
                .funcionarioId(request.getEmployeeId())
                .equipamentoId(request.getEquipmentId())
                .dataMovimentacao(request.getDataMovimentacao())
                .build();
    }
}