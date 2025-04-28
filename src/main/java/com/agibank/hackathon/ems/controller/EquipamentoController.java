package com.agibank.hackathon.ems.controller;

import com.agibank.hackathon.ems.controller.request.equipamento.CriarEquipamentoRequest;
import com.agibank.hackathon.ems.repository.EquipamentoRepository;
import com.agibank.hackathon.ems.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/equipamentos")
@RestController
public class EquipamentoController {

    @Autowired
    EquipamentoRepository equipamentoRepository;
    @Autowired
    EquipamentoService equipamentoService;

    @PostMapping
    public ResponseEntity<String> cadastroEquipamento (@RequestBody CriarEquipamentoRequest request){
        equipamentoService.cadastrarEquipamento(request);
        return ResponseEntity.ok("Cadastro Concluído");
    }

}
