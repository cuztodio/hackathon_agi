package com.agibank.hackathon.ems.repository;

import com.agibank.hackathon.ems.entity.Equipamentos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends MongoRepository <Equipamentos,String> {
}
