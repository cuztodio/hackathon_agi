package com.agibank.hackathon.ems.service;

import com.agibank.hackathon.ems.controller.request.funcionario.CriarFuncionarioRequest;
import com.agibank.hackathon.ems.entity.Funcionario;
import com.agibank.hackathon.ems.mapper.FuncionarioMapper;
import com.agibank.hackathon.ems.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioMapper funcionarioMapper;

    public Funcionario cadastrarFuncionario (CriarFuncionarioRequest request) {
        Funcionario funcionario = funcionarioMapper.cadastroFuncionario(request);
        return funcionarioRepository.save(funcionario);
    }






}
