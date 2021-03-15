package com.example.demo.api;

import com.example.demo.model.Banca;
import com.example.demo.service.BancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BancaController {

    @Autowired
    BancaService service;

    @GetMapping("/banca")
    public List<Banca> getBanca() {
        return this.service.getBanca();
    }
}
