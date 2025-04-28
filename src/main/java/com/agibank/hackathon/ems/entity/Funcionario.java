package com.agibank.hackathon.ems.entity;


import com.agibank.hackathon.ems.enums.StatusFuncionario;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Builder
@Data
public class Funcionario {
    @Id
    private String id;
    private String nome;
    @Indexed(unique = true)
    private String cpf;
    private StatusFuncionario status;


}
