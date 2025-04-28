package com.agibank.hackathon.ems.service;

import com.agibank.hackathon.ems.controller.request.funcionario.CriarFuncionarioRequest;
import com.agibank.hackathon.ems.controller.request.funcionario.SolicitarDesligamentoFuncionarioRequest;
import com.agibank.hackathon.ems.entity.Funcionario;
import com.agibank.hackathon.ems.enums.StatusFuncionario;
import com.agibank.hackathon.ems.exceptions.DesligamentoNaoAprovadoException;
import com.agibank.hackathon.ems.exceptions.FuncionarioNaoEncontradoException;
import com.agibank.hackathon.ems.mapper.FuncionarioMapper;
import com.agibank.hackathon.ems.repository.FuncionarioRepository;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
 public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioMapper funcionarioMapper;

    public Funcionario cadastrarFuncionario (CriarFuncionarioRequest request) {
        Funcionario funcionario = funcionarioMapper.cadastroFuncionario(request);
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario editarFuncionario (String id, SolicitarDesligamentoFuncionarioRequest request){
        Funcionario funcionarioAlterado = funcionarioMapper.editarFuncionario(id,request);
        return funcionarioRepository.save(funcionarioAlterado);
    }


//    public Funcionario solicitarDesligamento(String cpf, SolicitarDesligamentoFuncionarioRequest request) throws InvocationTargetException, IllegalAccessException {
//        Funcionario funcionario = verificarFuncionarioExistente(cpf);
//        BeanUtilsBean.getInstance().copyProperties(funcionario, request);
//        funcionario.setStatus(request.getStatus());
//        return funcionarioRepository.save(funcionario);
//
//        if (request.getStatus() == StatusFuncionario.EM_DESLIGAMENTO){
//            boolean aprovado = DesligamentoSerivice.aprovarDesligamento(funcionario.getCpf());
//        }
//        if (!aprovado) {
//            throw new DesligamentoNaoAprovadoException("Solicitação de desligamento não aprovada, verifique suas pendências");
//        }
//        return funcionarioRepository.save(funcionario);
//    }

    public Funcionario verificarFuncionarioExistente (String cpf){
        return funcionarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário com CPF " + cpf + " não encontrado"));
    }








}
