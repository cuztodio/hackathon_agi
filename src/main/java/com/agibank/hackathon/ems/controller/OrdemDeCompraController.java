package com.agibank.hackathon.ems.controller;


import com.agibank.hackathon.ems.mapper.OrdemDeCompraMapper;
import com.agibank.hackathon.ems.repository.OrdemDeCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/compra")
@RestController
public class OrdemDeCompraController {

    @Autowired
    OrdemDeCompraRepository ocRepository;

    @Autowired
    OrdemDeCompraMapper ocMapper;

    @GetMapping
    public 



}
