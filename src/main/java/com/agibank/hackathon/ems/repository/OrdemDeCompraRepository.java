package com.agibank.hackathon.ems.repository;

import com.agibank.hackathon.ems.entity.OrdemDeCompra;
import com.agibank.hackathon.ems.enums.StatusOrdemDeCompra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrdemDeCompraRepository extends MongoRepository<OrdemDeCompra, String> {
    List<OrdemDeCompra> findByStatus(StatusOrdemDeCompra statusOrdemDeCompra);
}
