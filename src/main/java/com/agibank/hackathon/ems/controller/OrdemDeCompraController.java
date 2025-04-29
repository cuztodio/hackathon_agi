package com.agibank.hackathon.ems.controller;


import com.agibank.hackathon.ems.controller.request.oc.CriarOrdemDeCompraRequest;
import com.agibank.hackathon.ems.controller.request.oc.EditarStatusOrdemDeCompraRequest;
import com.agibank.hackathon.ems.entity.OrdemDeCompra;
import com.agibank.hackathon.ems.repository.OrdemDeCompraRepository;
import com.agibank.hackathon.ems.service.OrdemDeCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/compra")
@RestController
public class OrdemDeCompraController {

    @Autowired
    OrdemDeCompraRepository ocRepository;

    @Autowired
    OrdemDeCompraService ocService;

    @GetMapping
    List<OrdemDeCompra> listarOrdensDeCompra() {
        return ocRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> criarOrdemDeCompra(@RequestBody CriarOrdemDeCompraRequest request) {
        ocService.criarOrdemDeCompra(request);
        return ResponseEntity.ok("Ordem de Compra Registrada");
    }


    @PatchMapping("/{id}")
    public ResponseEntity<String> atualizarStatusOC(@PathVariable String id,
                                                    @RequestBody EditarStatusOrdemDeCompraRequest request) {
        ocService.alterarStatusOC(id, request);
        return ResponseEntity.ok("Ordem de Compra Concluída!");
    }


}



