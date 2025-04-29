package com.agibank.hackathon.ems.mapper;


import com.agibank.hackathon.ems.controller.request.equipamento.CriarEquipamentoRequest;
import com.agibank.hackathon.ems.controller.request.equipamento.EditarEquipamento;
import com.agibank.hackathon.ems.controller.request.equipamento.EditarStatusEquipamentoRequest;
import com.agibank.hackathon.ems.entity.Equipamentos;
import com.agibank.hackathon.ems.enums.StatusEquipamento;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class EquipamentoMapper {
    public Equipamentos cadastroEquipamento(@Valid CriarEquipamentoRequest request) {
        return Equipamentos.builder()
                .tipo(request.getTipo())
                .modelo(request.getModelo())
                .sku(request.getSku())
                .statusEquipamento(StatusEquipamento.DISPONIVEL)
                .build();
    }

    public Equipamentos editarEquipamento(@Valid EditarEquipamento request) {
        return Equipamentos.builder()
                .tipo(request.getTipo())
                .modelo(request.getModelo())
                .sku(request.getSku())
                .statusEquipamento(request.getStatusEquipamento())
                .build();

    }

    public Equipamentos editarStatusEquipamento(String id ,@Valid EditarStatusEquipamentoRequest request) {
        return Equipamentos.builder()
                .statusEquipamento(request.getStatusEquipamento())
                .build();
    }
}