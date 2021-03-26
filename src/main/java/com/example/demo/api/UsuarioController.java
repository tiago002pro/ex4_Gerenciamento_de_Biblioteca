package com.example.demo.api;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping("/usuarios")
    public String cadastraUsuario(@RequestBody Map<String, Object> json) {
        return this.service.cadastraUsuario(json);
    }

    @GetMapping("/usuarios")
    public List<Usuario> getPessoas() {
        return this.service.getUsuarios();
    }
}
