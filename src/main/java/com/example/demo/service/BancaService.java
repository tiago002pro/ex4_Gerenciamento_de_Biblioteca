package com.example.demo.service;

import com.example.demo.model.Banca;
import com.example.demo.model.Periodico;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BancaService {
    List<Banca> banca = new ArrayList();

    public List<Banca> getBanca() {
        return banca;
    }
}
