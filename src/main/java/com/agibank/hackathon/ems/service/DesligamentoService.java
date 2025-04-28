package com.agibank.hackathon.ems.service;

import com.agibank.hackathon.ems.entity.Movimentacao;
import com.agibank.hackathon.ems.repository.FuncionarioRepository;
import com.agibank.hackathon.ems.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesligamentoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public boolean aprovarDesligamento(String cpfFuncionario) {
        List<Movimentacao> pendencias = movimentacaoRepository.findByCpf(cpfFuncionario);

        return pendencias.isEmpty();
    }
}
