package com.agibank.hackathon.ems.service;

import com.agibank.hackathon.ems.controller.request.funcionario.CriarFuncionarioRequest;
import com.agibank.hackathon.ems.controller.request.funcionario.EditarFuncionarioRequest;
import com.agibank.hackathon.ems.controller.request.funcionario.SolicitarDesligamentoFuncionarioRequest;
import com.agibank.hackathon.ems.controller.request.movimentacao.CriarMovimentacaoRequest;
import com.agibank.hackathon.ems.controller.request.movimentacao.SolicitarEmprestimoFuncionarioRequest;
import com.agibank.hackathon.ems.entity.Funcionario;
import com.agibank.hackathon.ems.entity.Movimentacao;
import com.agibank.hackathon.ems.enums.StatusFuncionario;
import com.agibank.hackathon.ems.exceptions.DesligamentoNaoAprovadoException;
import com.agibank.hackathon.ems.exceptions.FuncionarioNaoAtivoException;
import com.agibank.hackathon.ems.exceptions.FuncionarioNaoEncontradoException;
import com.agibank.hackathon.ems.mapper.FuncionarioMapper;
import com.agibank.hackathon.ems.repository.FuncionarioRepository;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
 public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioMapper funcionarioMapper;

    @Autowired
    private DesligamentoService desligamentoService;

    @Autowired
    private MovimentacaoService movimentacaoService;

    public Funcionario cadastrarFuncionario (CriarFuncionarioRequest request) {
        Funcionario funcionario = funcionarioMapper.cadastroFuncionario(request);
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario editarFuncionario (String id, EditarFuncionarioRequest request){
        Funcionario funcionarioAlterado = funcionarioMapper.editarFuncionario(id,request);
        return funcionarioRepository.save(funcionarioAlterado);
    }


  public Funcionario solicitarDesligamento(String cpf, SolicitarDesligamentoFuncionarioRequest request) throws InvocationTargetException, IllegalAccessException {
        Funcionario funcionario = verificarFuncionarioExistente(cpf);

        BeanUtilsBean.getInstance().copyProperties(funcionario, request);
        funcionario.setStatus(request.getStatus());
         boolean aprovado = false;


        if (request.getStatus() == StatusFuncionario.EM_DESLIGAMENTO){
            aprovado = desligamentoService.aprovarDesligamento(funcionario.getCpf());
        }
        if (!aprovado) {
            throw new DesligamentoNaoAprovadoException("Solicitação de desligamento não aprovada, verifique suas pendências");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario verificarFuncionarioExistente (String cpf){
        return funcionarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário com CPF " + cpf + " não encontrado"));
    }

    public List<Funcionario> listarFuncionariosPorStatus(StatusFuncionario status) {
        return funcionarioRepository.findByStatus(status);
    }

    public Movimentacao solicitarEmprestimoEquipamento(SolicitarEmprestimoFuncionarioRequest request) {
        Funcionario funcionario = verificarFuncionarioExistente(request.getCpf());

        if (funcionario.getStatus() != StatusFuncionario.ATIVO) {
            throw new FuncionarioNaoAtivoException("Funcionário não está ativo e não pode solicitar equipamentos");
        }

        CriarMovimentacaoRequest criarRequest = new CriarMovimentacaoRequest();
        criarRequest.setSku(request.getSku());
        criarRequest.setDataMovimentacao(request.getDataMovimentacao());
        criarRequest.setMovimentacao(request.getMovimentacao());

        return movimentacaoService.criarMovimento(criarRequest);
    }

    public void deletarFuncionario(String cpf) {
        Funcionario funcionario = verificarFuncionarioExistente(cpf);
        funcionarioRepository.delete(funcionario);
    }


}