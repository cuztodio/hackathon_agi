package com.agibank.hackathon.ems.mapper;


import com.agibank.hackathon.ems.controller.request.oc.CriarOrdemDeCompraRequest;
import com.agibank.hackathon.ems.controller.request.oc.EditarOrdemDeCompraRequest;
import com.agibank.hackathon.ems.entity.OrdemDeCompra;
import com.agibank.hackathon.ems.enums.StatusOrdemDeCompra;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class OrdemDeCompraMapper {

    public OrdemDeCompra criarOrdemDeCompra (@Valid CriarOrdemDeCompraRequest request) {
        return OrdemDeCompra.builder()
                .idFuncionario(request.getIdFuncionario())
                .sku(request.getSku())
                .status(StatusOrdemDeCompra.PENDENTE)
                .build();
    }

    public OrdemDeCompra editarOrdemDeCompra (@Valid EditarOrdemDeCompraRequest request) {
        return OrdemDeCompra.builder()
                .idFuncionario(request.getIdFuncionario())
                .sku(request.getSku())
                .status(request.getComprado())
                .build();
    }


}
