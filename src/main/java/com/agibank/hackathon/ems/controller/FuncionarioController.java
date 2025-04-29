package com.agibank.hackathon.ems.controller;


import com.agibank.hackathon.ems.controller.request.funcionario.CriarFuncionarioRequest;
import com.agibank.hackathon.ems.controller.request.funcionario.EditarFuncionarioRequest;
import com.agibank.hackathon.ems.controller.request.funcionario.SolicitarDesligamentoFuncionarioRequest;
import com.agibank.hackathon.ems.entity.Funcionario;
import com.agibank.hackathon.ems.enums.StatusFuncionario;
import com.agibank.hackathon.ems.repository.FuncionarioRepository;
import com.agibank.hackathon.ems.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping ("/funcionario")
@RestController
public class FuncionarioController {
private static final Logger logger = LoggerFactory.getLogger(FuncionarioController.class);

    @Autowired
    FuncionarioService funcionarioService;
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @PostMapping
    public ResponseEntity<String> cadastroFuncionario (@RequestBody CriarFuncionarioRequest request) {
        logger.info("Requisição recebida para cadastrar funcionário: {}", request);
        funcionarioService.cadastrarFuncionario(request);
        return ResponseEntity.ok("Cadastro Concluído");
    }


    @GetMapping("/listar")
    List<Funcionario> listarFuncionarios() {
        logger.info("Listando todos os funcionários");
        return (List<Funcionario>) funcionarioRepository.findAll();
    }

    @GetMapping("/status")
    public ResponseEntity<List<Funcionario>> listarStatus(@RequestParam StatusFuncionario status) {
        logger.info("Listando funcionários por status: {}", status);
        List<Funcionario> funcionarios = funcionarioService.listarFuncionariosPorStatus(status);
        return ResponseEntity.ok(funcionarios);
    }

    @PutMapping("/{id}/editar")
    public ResponseEntity<String> editarFuncionario (@PathVariable String id , @RequestBody EditarFuncionarioRequest request){
        logger.info("Editando funcionário com ID: {}", id);
        funcionarioService.editarFuncionario(id,request);
        return ResponseEntity.ok("Funcionario editado com sucesso!");
    }


  @PatchMapping("/cpf/{cpf}/desligar")
 public ResponseEntity<String> solicitarDesligamento(@PathVariable String cpf, @RequestBody SolicitarDesligamentoFuncionarioRequest request)
          throws InvocationTargetException, IllegalAccessException {
      logger.info("Solicitação de desligamento para CPF: {}", cpf);
    funcionarioService.solicitarDesligamento(cpf, request);
    return ResponseEntity.ok("Funcionário desligado com sucesso!");
}

 @GetMapping("/{cpf}/cpf")
    public ResponseEntity<Funcionario> buscarFuncionarioPorCpf(@PathVariable String cpf) {
     logger.info("Buscando funcionário pelo CPF: {}", cpf);
        Funcionario funcionario = funcionarioService.verificarFuncionarioExistente(cpf);
        return ResponseEntity.ok(funcionario);
    }








}
