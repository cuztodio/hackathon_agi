package com.agibank.hackathon.ems.entity;

import com.agibank.hackathon.ems.enums.StatusEquipamento;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Equipamentos {
    @Id
    private String id;
    private StatusEquipamento statusEquipamento;

    @NotBlank
    private String tipo;
    @NotBlank
    private String modelo;
    @NotBlank
    private String sku;
}
