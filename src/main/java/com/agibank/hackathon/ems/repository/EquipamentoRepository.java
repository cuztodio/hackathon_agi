package com.agibank.hackathon.ems.repository;

import com.agibank.hackathon.ems.entity.Equipamentos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipamentoRepository extends MongoRepository <Equipamentos,String> {

    List<Equipamentos> findByIdEquipamento(String idEquipamentos);

    List<Equipamentos> findBySku(String sku);

    List<Equipamentos> findByFuncionarioCpf(String cpf);
}
