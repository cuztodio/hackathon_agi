package com.agibank.hackathon.ems.service;

import com.agibank.hackathon.ems.controller.request.movimentacao.CriarMovimentacaoRequest;
import com.agibank.hackathon.ems.entity.Movimentacao;
import com.agibank.hackathon.ems.enums.StatusMovimentacao;
import com.agibank.hackathon.ems.repository.MovimentacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;

    public Movimentacao criarMovimento(CriarMovimentacaoRequest request) {
        Movimentacao movimentacao = Movimentacao.builder()
                .funcionarioId(request.getEmployeeId()) // ou funcionarioId
                .equipamentoId(request.getEquipmentId())
                .dataMovimentacao(LocalDateTime.now())
                .statusMovimentacao(StatusMovimentacao.EMPRESTADO)
                .build();

        return movimentacaoRepository.save(movimentacao);
    }

    public Movimentacao finalizarMovimento(String movimentoId) {
        return movimentacaoRepository.findById(movimentoId)
                .map(m -> {
                    m.setDataMovimentacao(LocalDateTime.now());
                    m.setStatusMovimentacao(StatusMovimentacao.DEVOLUCAO);
                    return movimentacaoRepository.save(m);
                })
                .orElseThrow(() -> new RuntimeException("Movimento nao encontrado."));
    }

    public List<Movimentacao> getHistoricoFuncionario(String funcionarioId) {
        return movimentacaoRepository.findByFuncionarioId(funcionarioId);
    }
}