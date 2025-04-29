package com.agibank.hackathon.ems.repository;

import com.agibank.hackathon.ems.entity.Equipamentos;
import com.agibank.hackathon.ems.entity.Movimentacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface EquipamentoRepository extends MongoRepository <Equipamentos,String> {

    List<Equipamentos> findByidEquipamentos(String idEquipamentos);

        List<Equipamentos> findBySku(String sku);
}
