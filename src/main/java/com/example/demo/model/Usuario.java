package com.example.demo.model;

import java.util.List;

public class Usuario {
    private String nome;
    private List<Emprestimo> emprestimoList;
    private Integer qtdEmprestimo;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setRegistroList(List<Emprestimo> emprestimoList) {
        this.emprestimoList = emprestimoList;
    }

    public List<Emprestimo> getRegistroList() {
        return emprestimoList;
    }

    public void setQtdEmprestimo(Integer qtdEmprestimo) {
        this.qtdEmprestimo = qtdEmprestimo;
    }

    public Integer getQtdEmprestimo() {
        return qtdEmprestimo;
    }
}
