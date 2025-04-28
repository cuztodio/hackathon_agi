package com.agibank.hackathon.ems.mapper;
import com.agibank.hackathon.ems.controller.request.*;
import com.agibank.hackathon.ems.entity.Funcionario;
import com.agibank.hackathon.ems.enums.StatusFuncionario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public Funcionario cadastroFuncionario (@Valid CriarFuncionarioRequest request){
        return Funcionario.builder()
                .nome(request.getNome())
                .cpf(request.getCpf())
                .status(StatusFuncionario.ATIVO)
                .build();
    }

    public Funcionario editarFuncionario (String id, @Valid EditarFuncionarioRequest request){
        return Funcionario.builder()
                .id(id)
                .nome(request.getNome())
                .cpf(request.getCpf())
                .status(request.getStatus())
                .build();
    }


}
