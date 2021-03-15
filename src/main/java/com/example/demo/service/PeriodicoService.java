package com.example.demo.service;

import com.example.demo.model.Livro;
import com.example.demo.model.Periodico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PeriodicoService {

    @Autowired
        BancaService bancaService;

    List<Periodico> periodicos = new ArrayList<>();

    public String cadastraPeriodico(Map<String, Object> json) {
        Periodico periodico = new Periodico();

        periodico.setTipo("Periódico");
        periodico.setTitulo((String) json.get("Título"));
        periodico.setAssunto((String) json.get("Assunto"));
        periodicos.add(periodico);
        bancaService.banca.add(periodico);

        return "Periódico cadastrado com sucesso!";
    }

    public List<Periodico> getPeriodicos() {
        return periodicos;
    }
}
