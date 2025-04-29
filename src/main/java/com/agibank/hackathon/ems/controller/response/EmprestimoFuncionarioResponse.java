package com.agibank.hackathon.ems.controller.response;

import com.agibank.hackathon.ems.enums.StatusMovimentacao;

public class EmprestimoFuncionarioResponse {
    private String id;
    private StatusMovimentacao statusMovimentacao;

    public EmprestimoFuncionarioResponse() {
    }

    public EmprestimoFuncionarioResponse(String id, StatusMovimentacao statusMovimentacao) {
        this.id = id;
        this.statusMovimentacao = statusMovimentacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StatusMovimentacao getStatusMovimentacao() {
        return statusMovimentacao;
    }

    public void setStatusMovimentacao(StatusMovimentacao statusMovimentacao) {
        this.statusMovimentacao = statusMovimentacao;
    }
}
