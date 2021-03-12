package com.example.demo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private Livro livro;
    private LocalDate vencimentoDevolucao;

    private Boolean devolucao = false;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate diaDevolucao;
    private Boolean atraso;
    private Integer diasEmAtraso;
    private Float multa;


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




    public void setDevolucao(Boolean devolucao) {
        this.devolucao = devolucao;
    }

    public Boolean getDevolucao() {
        return devolucao;
    }

    public void setDiaDevolucao(LocalDate diaDevolucao) {
        this.diaDevolucao = diaDevolucao;
    }

    public LocalDate getDiaDevolucao() {
        return diaDevolucao;
    }

    public void setAtraso(Boolean atraso) {
        this.atraso = atraso;
    }

    public Boolean getAtraso() {
        return atraso;
    }

    public void setDiasEmAtraso(Integer diasEmAtraso) {
        this.diasEmAtraso = diasEmAtraso;
    }

    public Integer getDiasEmAtraso() {
        return diasEmAtraso;
    }

    public void setMulta(Float multa) {
        this.multa = multa;
    }

    public Float getMulta() {
        return multa;
    }
}
