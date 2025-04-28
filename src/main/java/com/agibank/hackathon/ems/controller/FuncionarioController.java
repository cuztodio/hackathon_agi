package com.agibank.hackathon.ems.controller;


import com.agibank.hackathon.ems.controller.request.funcionario.CriarFuncionarioRequest;
import com.agibank.hackathon.ems.entity.Funcionario;
import com.agibank.hackathon.ems.repository.FuncionarioRepository;
import com.agibank.hackathon.ems.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping ("/funcionario")
@RestController
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @PostMapping
    public ResponseEntity<String> cadastroFuncionario (@RequestBody CriarFuncionarioRequest request) {
        funcionarioService.cadastrarFuncionario(request);
        return ResponseEntity.ok("Cadastro Concluído");
    }

    @GetMapping
    List<Funcionario> listarFuncionarios(){
        return (List<Funcionario>) funcionarioRepository.findAll();
    }








}
