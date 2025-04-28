package com.agibank.hackathon.ems.mapper;
import com.agibank.hackathon.ems.controller.request.CriarFuncionarioRequest;
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
}
