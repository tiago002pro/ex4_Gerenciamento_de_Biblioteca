package com.example.demo.model;

import java.util.List;

public class Usuario {
    private String nome;
    private Integer qtdEmprestimo;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setQtdEmprestimo(Integer qtdEmprestimo) {
        this.qtdEmprestimo = qtdEmprestimo;
    }

    public Integer getQtdEmprestimo() {
        return qtdEmprestimo;
    }
}
