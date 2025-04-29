package com.agibank.hackathon.ems.controller;


import com.agibank.hackathon.ems.controller.request.funcionario.CriarFuncionarioRequest;
import com.agibank.hackathon.ems.controller.request.funcionario.EditarFuncionarioRequest;
import com.agibank.hackathon.ems.controller.request.funcionario.SolicitarDesligamentoFuncionarioRequest;
import com.agibank.hackathon.ems.controller.request.movimentacao.CriarMovimentacaoRequest;
import com.agibank.hackathon.ems.controller.request.movimentacao.SolicitarEmprestimoFuncionarioRequest;
import com.agibank.hackathon.ems.controller.response.EmprestimoFuncionarioResponse;
import com.agibank.hackathon.ems.entity.Funcionario;
import com.agibank.hackathon.ems.entity.Movimentacao;
import com.agibank.hackathon.ems.enums.StatusFuncionario;
import com.agibank.hackathon.ems.repository.FuncionarioRepository;
import com.agibank.hackathon.ems.service.FuncionarioService;
import com.agibank.hackathon.ems.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.agibank.hackathon.ems.controller.response.EmprestimoFuncionarioResponse;

import java.lang.reflect.InvocationTargetException;
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


    @GetMapping("/listar")
    List<Funcionario> listarFuncionarios() {
        return (List<Funcionario>) funcionarioRepository.findAll();
    }

    @GetMapping("/status")
    public ResponseEntity<List<Funcionario>> listarStatus(@RequestParam StatusFuncionario status) {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionariosPorStatus(status);
        return ResponseEntity.ok(funcionarios);
    }

    @PutMapping("/{id}/editar")
    public ResponseEntity<String> editarFuncionario (@PathVariable String id , @RequestBody EditarFuncionarioRequest request){
        funcionarioService.editarFuncionario(id,request);
        return ResponseEntity.ok("Funcionario editado com sucesso!");
    }


  @PatchMapping("/cpf/{cpf}/desligar")
  public ResponseEntity<String> solicitarDesligamento(@PathVariable String cpf, @RequestBody SolicitarDesligamentoFuncionarioRequest request) throws InvocationTargetException, IllegalAccessException {
    funcionarioService.solicitarDesligamento(cpf, request);
    return ResponseEntity.ok("Funcionário desligado com sucesso!");
    }

    @GetMapping("/{cpf}/cpf")
    public ResponseEntity<Funcionario> buscarFuncionarioPorCpf(@PathVariable String cpf) {
        Funcionario funcionario = funcionarioService.verificarFuncionarioExistente(cpf);
        return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping("/{cpf}/deletar")
    public ResponseEntity<String> deletarFuncionario(@PathVariable String cpf) {
        funcionarioService.deletarFuncionario(cpf);
        return ResponseEntity.ok("Funcionário deletado com sucesso!");
    }

    @PostMapping("emprestimo")
    public ResponseEntity<EmprestimoFuncionarioResponse> solicitarEquipamentoFuncionario(
            @RequestBody SolicitarEmprestimoFuncionarioRequest request) {

        Movimentacao movimentacao = funcionarioService.solicitarEmprestimoEquipamento(request);

        EmprestimoFuncionarioResponse response = new EmprestimoFuncionarioResponse(
                movimentacao.getId(),
                movimentacao.getStatusMovimentacao()
        );

        return ResponseEntity.ok(response);
    }









}
