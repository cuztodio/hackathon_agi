package com.agibank.hackathon.ems.repository;

import com.agibank.hackathon.ems.entity.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

}
