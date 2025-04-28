package com.agibank.hackathon.ems.service;


import com.agibank.hackathon.ems.controller.request.oc.*;
import com.agibank.hackathon.ems.entity.OrdemDeCompra;
import com.agibank.hackathon.ems.enums.StatusOrdemDeCompra;
import com.agibank.hackathon.ems.mapper.OrdemDeCompraMapper;
import com.agibank.hackathon.ems.repository.OrdemDeCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemDeCompraService {

    @Autowired
    private OrdemDeCompraRepository ocRepository;

    @Autowired
    private OrdemDeCompraMapper ocMapper;

    public List<OrdemDeCompra> listarOrdensDeCompra (){
            return ocRepository.findAll();
    }

    public OrdemDeCompra criarOrdemDeCompra (CriarOrdemDeCompraRequest request) {
        OrdemDeCompra ordemDeCompra = ocMapper.criarOrdemDeCompra(request);
        return ocRepository.save(ordemDeCompra);
    }

    public OrdemDeCompra editarOrdemdeCompra (EditarOrdemDeCompraRequest request) {
        OrdemDeCompra ordemDeCompra = ocMapper.editarOrdemDeCompra(request);
        return ocRepository.save(ordemDeCompra);
    }

    public OrdemDeCompra alterarStatusOC (OrdemDeCompra ordemDeCompra) {
        StatusOrdemDeCompra status = ordemDeCompra.getComprado();
        if (status == StatusOrdemDeCompra.PENDENTE) {
            ordemDeCompra.setComprado(StatusOrdemDeCompra.CONCLUIDA);
            //aloca equipamento para funcionario pelo id (cria nova movimentação)
        }
        return ocRepository.save(ordemDeCompra);
    }

    /*
    public OrdemDeCompra alterarStatusOC (String id, EditarStatusOrdemDeCompraRequest request) {

        StatusOrdemDeCompra status = request.getComprado();
        if (status == StatusOrdemDeCompra.PENDENTE) {
            ordemDeCompra.setComprado(StatusOrdemDeCompra.CONCLUIDA);
            //aloca equipamento para funcionario pelo id (cria nova movimentação)
        }
        return ocRepository.save(ordemDeCompra);
    }

     */

}
