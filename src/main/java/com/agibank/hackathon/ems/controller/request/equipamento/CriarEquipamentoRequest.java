package com.agibank.hackathon.ems.controller.request.equipamento;

import com.agibank.hackathon.ems.enums.StatusEquipamento;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@Builder
public class CriarEquipamentoRequest {
    @NotBlank
    private String tipo;
    @NotBlank
    private String modelo;
    @NotBlank
    private String sku;
    private StatusEquipamento statusEquipamento;

}
