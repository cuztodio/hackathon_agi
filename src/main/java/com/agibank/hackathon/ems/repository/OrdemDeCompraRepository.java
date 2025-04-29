package com.agibank.hackathon.ems.repository;

import com.agibank.hackathon.ems.entity.OrdemDeCompra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdemDeCompraRepository extends MongoRepository<OrdemDeCompra, String> {

}
