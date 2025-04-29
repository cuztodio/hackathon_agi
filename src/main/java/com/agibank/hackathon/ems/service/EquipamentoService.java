package com.agibank.hackathon.ems.service;

import com.agibank.hackathon.ems.controller.request.equipamento.CriarEquipamentoRequest;
import com.agibank.hackathon.ems.controller.request.equipamento.EditarStatusEquipamentoRequest;
import com.agibank.hackathon.ems.controller.request.oc.CriarOrdemDeCompraRequest;
import com.agibank.hackathon.ems.entity.Equipamentos;
import com.agibank.hackathon.ems.entity.OrdemDeCompra;
import com.agibank.hackathon.ems.enums.StatusEquipamento;
import com.agibank.hackathon.ems.mapper.EquipamentoMapper;
import com.agibank.hackathon.ems.mapper.OrdemDeCompraMapper;
import com.agibank.hackathon.ems.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    @Autowired
    private OrdemDeCompraService ordemDeCompraService;
    @Autowired
    private OrdemDeCompraMapper ordemDeCompraMapper;
    @Autowired
    private EquipamentoRepository equipamentoRepository;
    @Autowired
    private EquipamentoMapper equipamentoMapper;

    public Equipamentos cadastrarEquipamento (CriarEquipamentoRequest request) {
        Equipamentos equipamentos = equipamentoMapper.cadastroEquipamento(request);
        return equipamentoRepository.save(equipamentos);
    }
    public Equipamentos editarStatusEquipamento (String idEquipamento, EditarStatusEquipamentoRequest request){
        Equipamentos statusEquipamentoAlterado = equipamentoMapper.editarStatusEquipamento(idEquipamento,request);
        return equipamentoRepository.save(statusEquipamentoAlterado);
    }


    public List<Equipamentos> verificarEquipamentosDisponiveisPorSku(String sku) {
        List<Equipamentos> equipamentosDisponiveis = equipamentoRepository.findBySku(sku).stream()
        .filter(equipamento -> equipamento.getStatusEquipamento() == StatusEquipamento.DISPONIVEL).toList();
        if (equipamentosDisponiveis.isEmpty()) {
            // TODO: fazer um fucionario
            throw new RuntimeException("Nenhum equipamento encontrado com o SKU fornecido.");
        }
        return equipamentosDisponiveis;
    }


}
