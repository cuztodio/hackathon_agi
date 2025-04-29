package com.agibank.hackathon.ems.entity;


import com.agibank.hackathon.ems.enums.StatusOrdemDeCompra;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "compra")
@Builder
@Data
public class OrdemDeCompra {
    @Id
    private String id;
    private String idFuncionario;
    private String sku;
    private StatusOrdemDeCompra status;
}
