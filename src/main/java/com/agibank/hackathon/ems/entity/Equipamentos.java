package com.agibank.hackathon.ems.entity;

import com.agibank.hackathon.ems.enums.StatusEquipamento;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Builder
@Data
public class Equipamentos {
    @Id
    private String id;
    private StatusEquipamento statusEquipamento;

    @NotBlank
    private String tipo;
    @NotBlank
    private String modelo;
    private String sku;
}
