package com.agibank.hackathon.ems.repository;

import com.agibank.hackathon.ems.entity.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
 Optional<Funcionario> findByCpf(String cpf);
}
