package com.agibank.hackathon.ems.service;


import com.agibank.hackathon.ems.controller.request.oc.*;
import com.agibank.hackathon.ems.entity.Equipamentos;
import com.agibank.hackathon.ems.entity.Movimentacao;
import com.agibank.hackathon.ems.entity.OrdemDeCompra;
import com.agibank.hackathon.ems.enums.StatusEquipamento;
import com.agibank.hackathon.ems.enums.StatusMovimentacao;
import com.agibank.hackathon.ems.enums.StatusOrdemDeCompra;
import com.agibank.hackathon.ems.exceptions.OrdemDeCompraNaoEncontrada;
import com.agibank.hackathon.ems.mapper.OrdemDeCompraMapper;
import com.agibank.hackathon.ems.repository.EquipamentoRepository;
import com.agibank.hackathon.ems.repository.MovimentacaoRepository;
import com.agibank.hackathon.ems.repository.OrdemDeCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdemDeCompraService {

    @Autowired
    private OrdemDeCompraRepository ocRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private OrdemDeCompraMapper ocMapper;


    public List<OrdemDeCompra> listarOrdensDeCompra (){
            return ocRepository.findAll();
    }

    public OrdemDeCompra criarOrdemDeCompra (CriarOrdemDeCompraRequest request, String sku) {
        OrdemDeCompra ordemDeCompra = ocMapper.criarOrdemDeCompra(request);
        ordemDeCompra.setSku(sku);
        return ocRepository.save(ordemDeCompra);
    }

    public OrdemDeCompra editarOrdemdeCompra (EditarOrdemDeCompraRequest request) {
        OrdemDeCompra ordemDeCompra = ocMapper.editarOrdemDeCompra(request);
        return ocRepository.save(ordemDeCompra);
    }


    public OrdemDeCompra alterarStatusOC (String id, EditarStatusOrdemDeCompraRequest request) {

        OrdemDeCompra ordemDeCompra =  ocRepository.findById(id)
                .orElseThrow(() -> new OrdemDeCompraNaoEncontrada("Ordem de compra não encontrada com ID: " + id));
        StatusOrdemDeCompra status = request.getStatus();
        if (status == StatusOrdemDeCompra.CONCLUIDA) {
            ordemDeCompra.setStatus(StatusOrdemDeCompra.CONCLUIDA);
            Equipamentos equipamento = Equipamentos.builder()
                    .tipo("Notebook - New")
                    .modelo("Dell Cinza")
                    .sku(ordemDeCompra.getSku())
                    .statusEquipamento(StatusEquipamento.ALOCADO)
                    .build();
            equipamentoRepository.save(equipamento);

            Movimentacao movimentacao = Movimentacao.builder()
                    .funcionarioId(ordemDeCompra.getIdFuncionario()) // ou funcionarioId
                    .equipamentoId(equipamento.getIdEquipamento())
                    .dataMovimentacao(LocalDateTime.now())
                    .statusMovimentacao(StatusMovimentacao.EMPRESTADO)
                    .build();
            movimentacaoRepository.save(movimentacao);

        }
        return ocRepository.save(ordemDeCompra);
    }

    public List<OrdemDeCompra> listarOCsPendentes () {
        return ocRepository.findByStatus(StatusOrdemDeCompra.PENDENTE);
    }


}
