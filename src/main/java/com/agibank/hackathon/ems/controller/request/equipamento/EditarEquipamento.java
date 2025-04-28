package com.agibank.hackathon.ems.controller.request.equipamento;

import com.agibank.hackathon.ems.enums.StatusEquipamento;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class EditarEquipamento {
        private String tipo;
        private String modelo;
        private String sku;
        private StatusEquipamento statusEquipamento;
    }

