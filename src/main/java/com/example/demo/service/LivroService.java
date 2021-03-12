package com.example.demo.service;

import com.example.demo.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LivroService {

    List<Livro> livros = new ArrayList<>();

    public String cadastraLivro(Map<String, Object> json) {
        Livro livro = new Livro();

        livro.setTitulo((String) json.get("Título"));
        livro.setAutor((String) json.get("Autor"));
        livros.add(livro);

        return "Livro cadastrado com sucesso!";
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
