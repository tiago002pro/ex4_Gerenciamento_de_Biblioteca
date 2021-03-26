package com.example.demo.api;

import com.example.demo.model.Livro;
import com.example.demo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class LivroController {

    @Autowired
        LivroService service;

    @PostMapping("/livros")
    public String cadastraLivro(@RequestBody Map<String, Object> json) {
        return this.service.cadastraLivro(json);
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return this.service.getLivros();
    }
}
