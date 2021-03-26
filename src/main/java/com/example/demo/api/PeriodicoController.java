package com.example.demo.api;

import com.example.demo.model.Livro;
import com.example.demo.model.Periodico;
import com.example.demo.service.LivroService;
import com.example.demo.service.PeriodicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PeriodicoController {

    @Autowired
    PeriodicoService service;

    @PostMapping("/periodicos")
    public String cadastraPeriodico(@RequestBody Map<String, Object> json) {
        return this.service.cadastraPeriodico(json);
    }

    @GetMapping("/periodicos")
    public List<Periodico> getPeriodico() {
        return this.service.getPeriodicos();
    }
}
