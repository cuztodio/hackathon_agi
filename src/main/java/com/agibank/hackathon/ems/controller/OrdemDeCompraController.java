package com.agibank.hackathon.ems.controller;


import com.agibank.hackathon.ems.controller.request.oc.CriarOrdemDeCompraRequest;
import com.agibank.hackathon.ems.controller.request.oc.EditarStatusOrdemDeCompraRequest;
import com.agibank.hackathon.ems.entity.OrdemDeCompra;
import com.agibank.hackathon.ems.enums.StatusOrdemDeCompra;
import com.agibank.hackathon.ems.repository.OrdemDeCompraRepository;
import com.agibank.hackathon.ems.service.OrdemDeCompraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/compra")
@RestController
public class OrdemDeCompraController {
    private static final Logger logger = LoggerFactory.getLogger(OrdemDeCompraController.class);

    @Autowired
    OrdemDeCompraRepository ocRepository;

    @Autowired
    OrdemDeCompraService ocService;

    @GetMapping
    List<OrdemDeCompra> listarOrdensDeCompra() {
        logger.info("Listando todas as ordens de compra");
        return ocRepository.findAll();
    }

    @GetMapping("/pendentes")
    List<OrdemDeCompra> listarOCsPendentes() {
        logger.info("Listando ordens de compra com status PENDENTE");
        return ocRepository.findByStatus(StatusOrdemDeCompra.PENDENTE);
    }

    @PostMapping
    public ResponseEntity<String> criarOrdemDeCompra(@RequestBody CriarOrdemDeCompraRequest request, String sku) {
        logger.info("Recebida requisição para criar ordem de compra com SKU: {}", sku);
        ocService.criarOrdemDeCompra(request, sku);
        return ResponseEntity.ok("Ordem de Compra Registrada");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> atualizarStatusOC(@PathVariable String id,
                                                    @RequestBody EditarStatusOrdemDeCompraRequest request) {
        logger.info("Atualizando status da ordem de compra com ID: {}", id);
        ocService.alterarStatusOC(id, request);
        return ResponseEntity.ok("Ordem de Compra Concluída!");
    }


}



