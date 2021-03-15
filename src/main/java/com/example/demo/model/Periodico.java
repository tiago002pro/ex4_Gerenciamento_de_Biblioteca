package com.example.demo.model;

public class Periodico extends Banca{

    private String assunto;

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getAssunto() {
        return assunto;
    }

    @Override
    public String getTitulo() {
        return super.getTitulo();
    }

    @Override
    public String getTipo() {
        return super.getTipo();
    }
}

