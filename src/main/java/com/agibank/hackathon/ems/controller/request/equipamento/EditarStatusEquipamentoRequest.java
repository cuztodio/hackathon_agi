package com.agibank.hackathon.ems.controller.request.equipamento;

import com.agibank.hackathon.ems.enums.StatusEquipamento;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EditarStatusEquipamentoRequest {
    private StatusEquipamento statusEquipamento;
}
