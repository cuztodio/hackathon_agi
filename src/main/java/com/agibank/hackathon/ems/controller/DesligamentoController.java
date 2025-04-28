package com.agibank.hackathon.ems.controller;

import com.agibank.hackathon.ems.controller.request.desligamento.DesligamentoRequest;
import com.agibank.hackathon.ems.entity.Desligamento;
import com.agibank.hackathon.ems.entity.Movimentacao;
import com.agibank.hackathon.ems.enums.StatusDesligamento;
import com.agibank.hackathon.ems.repository.DesligamentoRepository;
import com.agibank.hackathon.ems.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RequestMapping("/desligamento")
@RestController
public class DesligamentoController {

    @Autowired
    private DesligamentoRepository desligamentoRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @PostMapping
    public ResponseEntity<String> solicitarDesligamento(@RequestBody DesligamentoRequest request) {
        // Verifica se há pendências de devolução de equipamentos
        List<Movimentacao> pendencias = movimentacaoRepository.findPendencias(request.getIdFuncionario());

        if (!pendencias.isEmpty()) {
            return ResponseEntity.badRequest().body("Funcionário possui equipamentos pendentes para devolução.");
        }

        // Cria e salva o registro de desligamento
        Desligamento desligamento = Desligamento.builder()
                .idFuncionario(request.getIdFuncionario())
                .statusDesligamento(StatusDesligamento.AUTORIZADO)
                .dataDesligamento(new Date())
                .build();

        desligamentoRepository.save(desligamento);

        return ResponseEntity.ok("Desligamento concluído com sucesso.");
    }

    @GetMapping("/pendencias/{idFuncionario}")
    public ResponseEntity<List<Movimentacao>> consultarPendencias(@PathVariable String idFuncionario) {
        List<Movimentacao> pendencias = movimentacaoRepository.findPendencias(idFuncionario);
        return ResponseEntity.ok(pendencias);
    }
}
