package com.agibank.hackathon.ems.controller;

import com.agibank.hackathon.ems.controller.request.equipamento.CriarEquipamentoRequest;
import com.agibank.hackathon.ems.controller.request.equipamento.EditarStatusEquipamentoRequest;
import com.agibank.hackathon.ems.entity.Equipamentos;
import com.agibank.hackathon.ems.repository.EquipamentoRepository;
import com.agibank.hackathon.ems.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/equipamentos")
@RestController
public class EquipamentoController {

    @Autowired
    EquipamentoRepository equipamentoRepository;
    @Autowired
    EquipamentoService equipamentoService;

    @GetMapping
    List<Equipamentos> listarFuncionarios(){
        return (List<Equipamentos>) equipamentoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> cadastroEquipamento (@RequestBody CriarEquipamentoRequest request){
        equipamentoService.cadastrarEquipamento(request);
        return ResponseEntity.ok("Cadastro Concluído");
    }

    @PatchMapping ("/status/{idEquipamento}")
    public ResponseEntity<String> editarStatusEquipamento(@PathVariable String idEquipamento, @RequestBody EditarStatusEquipamentoRequest request){
        equipamentoService.editarStatusEquipamento(idEquipamento,request);
        return ResponseEntity.ok("Status do Equipamento alterado com sucesso");
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Equipamentos>> listarEquipamentosDisponiveisPorSku(@RequestParam String sku) {
        List<Equipamentos> equipamentosDisponiveis = equipamentoService.verificarEquipamentosDisponiveisPorSku(sku);
        return ResponseEntity.ok(equipamentosDisponiveis);
    }


}
