package com.example.demo.service;

import com.example.demo.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {

    List<Usuario> usuarios = new ArrayList<>();

    public String cadastraUsuario(Map<String, Object> json) {
        Usuario usuario = new Usuario();

        usuario.setNome((String) json.get("nome"));
        usuario.setQtdEmprestimo(0);
        usuarios.add(usuario);

        return "Usuário cadastrado com sucesso!";
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
