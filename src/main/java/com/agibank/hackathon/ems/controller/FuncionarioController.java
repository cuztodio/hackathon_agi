package com.agibank.hackathon.ems.controller;

import com.agibank.hackathon.ems.controller.request.funcionario.CriarFuncionarioRequest;
import com.agibank.hackathon.ems.controller.request.funcionario.EditarFuncionarioRequest;
import com.agibank.hackathon.ems.controller.request.funcionario.ListarFuncionariosPendentesRequest;
import com.agibank.hackathon.ems.controller.request.funcionario.SolicitarDesligamentoFuncionarioRequest;
import com.agibank.hackathon.ems.entity.Funcionario;
import com.agibank.hackathon.ems.repository.FuncionarioRepository;
import com.agibank.hackathon.ems.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RequestMapping("/funcionario")
@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping
    public ResponseEntity<String> cadastroFuncionario(@RequestBody CriarFuncionarioRequest request) {
        funcionarioService.cadastrarFuncionario(request);
        return ResponseEntity.ok("Cadastro Concluído");
    }

    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return (List<Funcionario>) funcionarioRepository.findAll();
    }

    @PutMapping("/{id}/editar")
    public ResponseEntity<String> editarFuncionario(@PathVariable String id, @RequestBody EditarFuncionarioRequest request) {
        funcionarioService.editarFuncionario(id, request);
        return ResponseEntity.ok("Funcionário editado com sucesso!");
    }

    @PatchMapping("/cpf/{cpf}/desligar")
    public ResponseEntity<String> solicitarDesligamento(@PathVariable String cpf, @RequestBody SolicitarDesligamentoFuncionarioRequest request)
            throws InvocationTargetException, IllegalAccessException {
        funcionarioService.solicitarDesligamento(cpf, request);
        return ResponseEntity.ok("Funcionário desligado com sucesso!");
    }

    @GetMapping("/pendentes-desligamento")
    public List<Funcionario> listarFuncionariosPendentesDesligamento() {
        ListarFuncionariosPendentesRequest request = new ListarFuncionariosPendentesRequest(funcionarioRepository);
        return request.listarFuncionariosEmDesligamento();
    }
}
