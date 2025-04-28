package com.agibank.hackathon.ems.repository;

import com.agibank.hackathon.ems.entity.Desligamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesligamentoRepository extends MongoRepository<Desligamento, String> {

}
