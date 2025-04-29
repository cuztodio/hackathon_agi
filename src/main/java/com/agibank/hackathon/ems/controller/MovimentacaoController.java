package com.agibank.hackathon.ems.controller;

import com.agibank.hackathon.ems.controller.request.movimentacao.CriarMovimentacaoRequest;
import com.agibank.hackathon.ems.controller.request.movimentacao.EditarMovimentacaoRequest;
import com.agibank.hackathon.ems.entity.Equipamentos;
import com.agibank.hackathon.ems.entity.Movimentacao;
import com.agibank.hackathon.ems.enums.StatusMovimentacao;
import com.agibank.hackathon.ems.repository.MovimentacaoRepository;
import com.agibank.hackathon.ems.service.MovimentacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movimentacao")
@RestController
public class MovimentacaoController {
    private static final Logger logger = LoggerFactory.getLogger(MovimentacaoController.class);


    @Autowired
    private MovimentacaoService movimentacaoService;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @PostMapping
    public ResponseEntity<String> solitacaoDeEquipamento(@RequestBody CriarMovimentacaoRequest criarMovimentacaoRequest){
        logger.info("Solicitação de criação de movimentação: {}", criarMovimentacaoRequest);
        movimentacaoService.criarMovimento(criarMovimentacaoRequest);
        return ResponseEntity.ok("Movimento criado!");
    }

    @PatchMapping("/{movimentoId}/devolucao")
    public ResponseEntity<Movimentacao> solicitarDevolucao(@PathVariable String movimentoId) {
        logger.info("Solicitação de devolução para movimentação ID: {}", movimentoId);
        Movimentacao devolvida = movimentacaoService.solicitarDevolucao(movimentoId);
        return ResponseEntity.ok(devolvida);
    }

    @PutMapping("/{id}/editarMovimentacao")
    public ResponseEntity<String> alteracaoDeMovimentacao(@PathVariable String id, @RequestBody EditarMovimentacaoRequest editarMovimentacaoRequest){
        logger.info("Solicitação de edição da movimentação ID: {}", id);
        movimentacaoService.editarMovimentacao(id, editarMovimentacaoRequest);
        return ResponseEntity.ok("Movimentacao alterada");
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<List<Movimentacao>> mostrarMovimentacoes(@PathVariable String id){
        logger.info("Listando histórico de movimentações para o funcionário ID: {}", id);
        List<Movimentacao> historico = movimentacaoService.getHistoricoFuncionario(id);
        return ResponseEntity.ok(historico);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Movimentacao>> buscarPorStatus(@PathVariable StatusMovimentacao status) {
        logger.info("Buscando movimentações por status: {}", status);
        List<Movimentacao> movimentacoes = movimentacaoService.buscarPorStatus(status);
        return ResponseEntity.ok(movimentacoes);
    }

    @GetMapping("/equipamentos/{funcionarioId}")
    public ResponseEntity<List<Equipamentos>> listarEquipamentosDoFuncionario(@PathVariable String funcionarioId) {
        logger.info("Listando equipamentos para o funcionário ID: {}", funcionarioId);
        List<Equipamentos> equipamentos = movimentacaoService.getEquipamentosFuncionario(funcionarioId);
        return ResponseEntity.ok(equipamentos);
    }

    @GetMapping("/funcionarios/{equipamentoId}")
    public ResponseEntity<List<String>> listarFuncionariosPorEquipamento(@PathVariable String equipamentoId) {
        logger.info("Listando funcionários que fizeram emprestimo de equipamento ID: {}", equipamentoId);
        List<String> funcionarios = movimentacaoService.getFuncionariosPorEquipamento(equipamentoId);
        return ResponseEntity.ok(funcionarios);
    }

    @PatchMapping("/{movimentoId}/manutencao")
    public ResponseEntity<Movimentacao> solicitarManutencao(@PathVariable String movimentoId) {
        logger.info("Solicitação de manutenção para movimentação ID: {}", movimentoId);
        Movimentacao emManutencao = movimentacaoService.solicitarManutencao(movimentoId);
        return ResponseEntity.ok(emManutencao);
    }
}