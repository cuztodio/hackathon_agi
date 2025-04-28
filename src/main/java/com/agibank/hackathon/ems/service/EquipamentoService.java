package com.agibank.hackathon.ems.service;

import com.agibank.hackathon.ems.controller.request.equipamento.CriarEquipamentoRequest;
import com.agibank.hackathon.ems.entity.Equipamentos;
import com.agibank.hackathon.ems.mapper.EquipamentoMapper;
import com.agibank.hackathon.ems.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;
    @Autowired
    private EquipamentoMapper equipamentoMapper;

    public Equipamentos cadastrarEquipamento (CriarEquipamentoRequest request) {
        Equipamentos equipamentos = equipamentoMapper.cadastroEquipamento(request);
        return equipamentoRepository.save(equipamentos);
    }

}
