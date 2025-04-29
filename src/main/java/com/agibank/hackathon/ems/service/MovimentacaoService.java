package com.agibank.hackathon.ems.service;

import com.agibank.hackathon.ems.controller.request.movimentacao.CriarMovimentacaoRequest;
import com.agibank.hackathon.ems.controller.request.movimentacao.EditarMovimentacaoRequest;
import com.agibank.hackathon.ems.entity.Equipamentos;
import com.agibank.hackathon.ems.entity.Movimentacao;
import com.agibank.hackathon.ems.enums.StatusMovimentacao;
import com.agibank.hackathon.ems.mapper.MovimentacaoMapper;
import com.agibank.hackathon.ems.repository.EquipamentoRepository;
import com.agibank.hackathon.ems.repository.MovimentacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MovimentacaoService {

    @Autowired
    private MovimentacaoMapper movimentacaoMapper;


    @Autowired
    private EquipamentoRepository equipamentoRepository;

    private final MovimentacaoRepository movimentacaoRepository;

    public Movimentacao criarMovimento(CriarMovimentacaoRequest request) {
       Movimentacao movimentacao = movimentacaoMapper.cadastroMovimentacao(request);

        return movimentacaoRepository.save(movimentacao);
    }

    public Movimentacao editarMovimentacao(String id, EditarMovimentacaoRequest request){
        Movimentacao movimentacaoAlterada = movimentacaoMapper.editarMovimentacao(id, request);

        return movimentacaoRepository.save(movimentacaoAlterada);
    }

    public Movimentacao solicitarDevolucao(String movimentoId) {
        return movimentacaoRepository.findById(movimentoId)
                .map(m -> {
                    m.setDataMovimentacao(LocalDateTime.now());
                    m.setStatusMovimentacao(StatusMovimentacao.DEVOLUCAO);
                    return movimentacaoRepository.save(m);
                })
                .orElseThrow(() -> new RuntimeException("Movimento nao encontrado."));
    }

    public Movimentacao solicitarEmprestimo(String movimentoId) {
        return movimentacaoRepository.findById(movimentoId)
                .map(m -> {
                    m.setDataMovimentacao(LocalDateTime.now());
                    m.setStatusMovimentacao(StatusMovimentacao.EMPRESTADO);
                    return movimentacaoRepository.save(m);
                })
                .orElseThrow(() -> new RuntimeException("Movimento nao encontrado."));
    }


    public List<Movimentacao> getHistoricoFuncionario(String funcionarioId) {
        return movimentacaoRepository.findByFuncionarioId(funcionarioId);
    }

    public List<Movimentacao> buscarPorStatus(StatusMovimentacao status) {
        return movimentacaoRepository.findByStatusMovimentacao(status);
    }

    public List<Equipamentos> getEquipamentosFuncionario(String funcionarioId) {
        List<Movimentacao> movimentacoes = movimentacaoRepository.findByFuncionarioId(funcionarioId);

        List<String> idsEquipamentos = movimentacoes.stream()
                .map(Movimentacao::getEquipamentoId) // Assumindo que existe esse campo
                .distinct()
                .toList();

        return equipamentoRepository.findAllById(idsEquipamentos);
    }

    public List<String> getFuncionariosPorEquipamento(String equipamentoId) {
        List<Movimentacao> movimentacoes = movimentacaoRepository.findByEquipamentoId(equipamentoId);

        return movimentacoes.stream()
                .map(Movimentacao::getFuncionarioId)
                .distinct()
                .toList();
    }

    public Movimentacao solicitarManutencao(String movimentoId) {
        return movimentacaoRepository.findById(movimentoId)
                .map(m -> {
                    m.setStatusMovimentacao(StatusMovimentacao.MANUTENCAO);
                    m.setDataMovimentacao(LocalDateTime.now());
                    return movimentacaoRepository.save(m);
                })
                .orElseThrow(() -> new RuntimeException("Movimentação não encontrada"));
    }
}