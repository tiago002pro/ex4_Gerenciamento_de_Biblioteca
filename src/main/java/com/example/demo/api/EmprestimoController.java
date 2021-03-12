package com.example.demo.api;

import com.example.demo.model.Emprestimo;
import com.example.demo.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EmprestimoController {

    @Autowired
    EmprestimoService service;

    @PostMapping("/emprestimo")
    public String registraEmprestimo(@RequestBody Map<String, Object> json) {
        return this.service.registraEmprestimo(json);
    }

    @GetMapping("/emprestimos")
    public List<Emprestimo> getEmprestimos() {
        return this.service.getEmprestimos();
    }

    @PostMapping("/emprestimo/devolução")
    public String devolucao(@RequestBody Map<String, Object> json) {
        return this.service.devolucaoEmprestimo(json);
    }

}
