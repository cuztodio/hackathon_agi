package com.agibank.hackathon.ems.repository;

import com.agibank.hackathon.ems.entity.Movimentacao;
import com.agibank.hackathon.ems.enums.StatusMovimentacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface MovimentacaoRepository extends MongoRepository<Movimentacao, String> {

    /*
    // Movimentacoes por usuario
    List<Movimentacao> findByFuncionarioId(String funcionarioId);

    //Movimentacoes do equipamento
    List<Movimentacao> findByEquipamentoId(String equipamentoId);

    //Movimentacoes por status
    List<Movimentacao> findByStatus(StatusMovimentacao status);

    //Encontrar emprestimos ativos
    @Query ("{'dataDevolucao': null}")
    List<Movimentacao> findAtivos();

    // Find itens a serem devolvidos por funcionario
    @Query("{ 'funcionarioId' : ?0, 'status' : 'EMPRESTADO' }")
    List<Movimentacao> findPendencias(String funcionarioId);

    // Find movimentacoes por funcionario e equipamento
    //List<Movimentacao> findByFuncionarioIdAndEquipamentoId(String funcionarioId, String equipamentoId);

     */
}
