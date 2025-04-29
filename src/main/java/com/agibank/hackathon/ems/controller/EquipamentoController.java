package com.agibank.hackathon.ems.controller;

import com.agibank.hackathon.ems.controller.request.equipamento.CriarEquipamentoRequest;
import com.agibank.hackathon.ems.controller.request.equipamento.EditarStatusEquipamentoRequest;
import com.agibank.hackathon.ems.controller.request.oc.CriarOrdemDeCompraRequest;
import com.agibank.hackathon.ems.entity.Equipamentos;
import com.agibank.hackathon.ems.repository.EquipamentoRepository;
import com.agibank.hackathon.ems.service.EquipamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/equipamentos")
@RestController
public class EquipamentoController {
    private static final Logger logger = LoggerFactory.getLogger(EquipamentoController.class);


    @Autowired
    EquipamentoRepository equipamentoRepository;
    @Autowired
    EquipamentoService equipamentoService;

    @GetMapping
    List<Equipamentos> listarFuncionarios(){
        logger.info("Listando todos os equipamentos");
        return (List<Equipamentos>) equipamentoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> cadastroEquipamento (@RequestBody CriarEquipamentoRequest request){
        logger.info("Recebida requisição para cadastrar equipamento: {}", request);
        equipamentoService.cadastrarEquipamento(request);
        return ResponseEntity.ok("Cadastro Concluído");
    }

    @PatchMapping ("/status/{idEquipamento}")
    public ResponseEntity<String> editarStatusEquipamento(@PathVariable String idEquipamento, @RequestBody EditarStatusEquipamentoRequest request){
        logger.info("Editando status do equipamento com ID: {}", idEquipamento);
        equipamentoService.editarStatusEquipamento(idEquipamento,request);
        return ResponseEntity.ok("Status do Equipamento alterado com sucesso");
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Equipamentos>> listarEquipamentosDisponiveisPorSku(CriarOrdemDeCompraRequest request, @PathVariable String sku) {
        logger.info("Listando equipamentos disponíveis para o SKU: {}", sku);
        List<Equipamentos> equipamentosDisponiveis = equipamentoService.verificarEquipamentosDisponiveisPorSku(request,sku);
        return ResponseEntity.ok(equipamentosDisponiveis);
    }


}
