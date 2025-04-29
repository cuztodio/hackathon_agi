package com.agibank.hackathon.ems.controller;

import com.agibank.hackathon.ems.controller.request.movimentacao.CriarMovimentacaoRequest;
import com.agibank.hackathon.ems.repository.MovimentacaoRepository;
import com.agibank.hackathon.ems.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movimentacao")
@RestController
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @PostMapping
    public ResponseEntity<String> criarMovimentacao(@RequestBody CriarMovimentacaoRequest criarMovimentacaoRequest){
        movimentacaoService.criarMovimento(criarMovimentacaoRequest);
        return ResponseEntity.ok("Movimento criado!");
    }
}