package com.agibank.hackathon.ems.repository;

import com.agibank.hackathon.ems.entity.Movimentacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovimentacaoRepository extends MongoRepository<Movimentacao, String> {
}
