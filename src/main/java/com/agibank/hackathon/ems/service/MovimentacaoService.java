package com.agibank.hackathon.ems.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

    public Movimentacao criarMovimento(Movimentacao movimentacao) {
        movimentacao.setDataMovimentacao(LocalDateTime.now());
        movimentacao.setMovimentacao(StatusMovimentacao.EMPRESTADO);
        return movimentacaoRepository.save(movimentacao);
    }

    public Movimentacao finalizarMovimento(String movimentoId) {
        return movimentacaoRepository.findById(movimentoId)
                .map(m -> {
                    m.setDataMovimentacao(LocalDateTime.now());
                    m.setMovimentacao(StatusMovimentacao.DEVOLUCAO);
                    return movimentacaoRepository.save(m);
                })
                .orElseThrow(() -> new RuntimeException("Movimento nao encontrado."));
    }

    public List<Movimentacao> getHistoricoFuncionario(String funcionarioId) {
        return movimentacaoRepository.findByFuncionarioId(funcionarioId);
    }
}
