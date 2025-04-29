package com.agibank.hackathon.ems.repository;

import com.agibank.hackathon.ems.entity.Funcionario;
import com.agibank.hackathon.ems.enums.StatusFuncionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

 public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
 Optional<Funcionario> findByCpf(String cpf);
 List<Funcionario> findByStatus(StatusFuncionario status);

}
