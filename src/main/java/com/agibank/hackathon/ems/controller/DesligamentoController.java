package com.agibank.hackathon.ems.controller;

import com.agibank.hackathon.ems.controller.request.funcionario.SolicitarDesligamentoFuncionarioRequest;
import com.agibank.hackathon.ems.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RequestMapping("/desligamento")
@RestController
public class DesligamentoController {

    @Autowired
    private FuncionarioService funcionarioService;

}
