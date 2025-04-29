package com.agibank.hackathon.ems.controller;

import com.agibank.hackathon.ems.controller.request.movimentacao.CriarMovimentacaoRequest;
import com.agibank.hackathon.ems.controller.request.movimentacao.EditarMovimentacaoRequest;
import com.agibank.hackathon.ems.entity.Movimentacao;
import com.agibank.hackathon.ems.repository.MovimentacaoRepository;
import com.agibank.hackathon.ems.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movimentacao")
@RestController
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @PostMapping
    public ResponseEntity<String> solitacaoDeEquipamento(@RequestBody CriarMovimentacaoRequest criarMovimentacaoRequest){
        movimentacaoService.criarMovimento(criarMovimentacaoRequest);
        return ResponseEntity.ok("Movimento criado!");
    }

    @PatchMapping("/{movimentoId}/devolucao")
    public ResponseEntity<Movimentacao> solicitarDevolucao(@PathVariable String movimentoId) {
        Movimentacao devolvida = movimentacaoService.solicitarDevolucao(movimentoId);
        return ResponseEntity.ok(devolvida);
    }

    @PutMapping("/{id}/editarMovimentacao")
    public ResponseEntity<String> alteracaoDeMovimentacao(@PathVariable String id, @RequestBody EditarMovimentacaoRequest editarMovimentacaoRequest){
        movimentacaoService.editarMovimentacao(id, editarMovimentacaoRequest);
        return ResponseEntity.ok("Movimentacao alterada");
    }

    @GetMapping("/movimentacao/{id}")
    public ResponseEntity<List<Movimentacao>> mostrarMovimentacoes(@PathVariable String id){
        List<Movimentacao> historico = movimentacaoService.getHistoricoFuncionario(id);
        return ResponseEntity.ok(historico);
    }
}