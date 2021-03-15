package com.example.demo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private Livro livro;
    private LocalDate vencimentoDevolucao;
    private LocalDate diaDevolucao;
    private Boolean devolucaoEmAtraso;
    private Integer diasEmAtraso;
    private Float multaAtrado;
    private Boolean multaPendente;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setVencimentoDevolucao(LocalDate vencimentoDevolucao) {
        this.vencimentoDevolucao = vencimentoDevolucao;
    }

    public LocalDate getVencimentoDevolucao() {
        return vencimentoDevolucao;
    }

    public void setDiaDevolucao(LocalDate diaDevolucao) {
        this.diaDevolucao = diaDevolucao;
    }

    public LocalDate getDiaDevolucao() {
        return diaDevolucao;
    }

    public void setDevolucaoEmAtraso(Boolean devolucaoEmAtraso) {
        this.devolucaoEmAtraso = devolucaoEmAtraso;
    }

    public Boolean getDevolucaoEmAtraso() {
        return devolucaoEmAtraso;
    }

    public void setDiasEmAtraso(Integer diasEmAtraso) {
        this.diasEmAtraso = diasEmAtraso;
    }

    public Integer getDiasEmAtraso() {
        return diasEmAtraso;
    }

    public void setMultaAtrado(Float multaAtrado) {
        this.multaAtrado = multaAtrado;
    }

    public Float getMultaAtrado() {
        return multaAtrado;
    }

    public void setMultaPendente(Boolean multaPendente) {
        this.multaPendente = multaPendente;
    }

    public Boolean getMultaPendente() {
        return multaPendente;
    }
}
