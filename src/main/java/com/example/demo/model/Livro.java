package com.example.demo.model;

public class Livro extends Banca{
    private String autor;
    private String editora;

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEditora() {
        return editora;
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
