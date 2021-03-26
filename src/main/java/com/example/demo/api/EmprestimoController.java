package com.example.demo.api;

import com.example.demo.model.Emprestimo;
import com.example.demo.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmprestimoController {

    @Autowired
    EmprestimoService service;

    @PostMapping("/emprestimo/usuario/{id}")
    public String registraEmprestimo(@PathVariable Integer id, @RequestBody Map<String, Object> json) {
        return this.service.registraEmprestimo(id, json);
    }

    @GetMapping("/emprestimos")
    public List<Emprestimo> getEmprestimos() {
        return this.service.getEmprestimos();
    }

    @PostMapping("/emprestimo/devolucao/usuario/{id}")
    public String devolucao(@PathVariable Integer id, @RequestBody Map<String, Object> json) {
        return this.service.devolucaoEmprestimo(id, json);
    }

    @PostMapping("/emprestimo/devolucao/regularizacao")
    public Emprestimo regularizaMulta(@RequestBody Map<String, Object> json) {
        return this.service.regularizaMulta(json);
    }
}
