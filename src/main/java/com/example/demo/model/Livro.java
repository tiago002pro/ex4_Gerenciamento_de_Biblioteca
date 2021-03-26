package com.example.demo.model;

public class Livro extends Banca{
    private String autor;

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
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
