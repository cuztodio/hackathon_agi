package com.agibank.hackathon.ems.controller.request.funcionario;

import com.agibank.hackathon.ems.entity.Funcionario;
import com.agibank.hackathon.ems.enums.StatusFuncionario;
import com.agibank.hackathon.ems.repository.FuncionarioRepository;
import java.util.List;

public class ListarFuncionariosPendentesRequest {

    private final FuncionarioRepository funcionarioRepository;

    public ListarFuncionariosPendentesRequest(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

   /* public List<Funcionario> listarFuncionariosEmDesligamento() {
        return funcionarioRepository.findBy(StatusFuncionario.EM_DESLIGAMENTO);
    } */
}
