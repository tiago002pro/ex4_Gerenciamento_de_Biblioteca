package com.example.demo.service;

import com.example.demo.model.Emprestimo;
import com.example.demo.model.Livro;
import com.example.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmprestimoService {

    @Autowired
        UsuarioService usuarioService;

    @Autowired
        LivroService livroService;

    List<Emprestimo> emprestimos = new ArrayList<>();

    public String registraEmprestimo(Map<String, Object> json) {
        Usuario usuario = usuarioService.usuarios.get((Integer) json.get("idUsuario"));
        List<Emprestimo> emprestimoRegistrado = usuario.getRegistroList();
        Livro livro = livroService.livros.get((Integer) json.get("idLivro"));
        Emprestimo emprestimo = new Emprestimo();

        if (usuario.getQtdEmprestimo() >= 2) {
            return "Não é possível fazer mais que 2 empréstimos simultâneos!";
        } else {
            emprestimo.setLivro(livro);
            emprestimo.setDataEmprestimo(LocalDate.now());
            emprestimo.setVencimentoDevolucao(LocalDate.now().plusDays(10));
            usuario.setQtdEmprestimo(usuario.getRegistroList().size());

            emprestimoRegistrado.add(emprestimo);
            emprestimos.add(emprestimo);
            usuario.setQtdEmprestimo(usuario.getRegistroList().size());

            return "Emprestimo realizado com seucesso!";
        }

    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public String devolucaoEmprestimo(Map<String, Object> json) {
        Usuario usuario = usuarioService.usuarios.get((Integer) json.get("idUsuario"));
        List<Emprestimo> emprestimoRegistrado = usuario.getRegistroList();
        Emprestimo emprestimo = emprestimos.get((Integer) json.get("idEmprestimo"));

        emprestimo.setDevolucao(true);
        emprestimo.setDiaDevolucao(LocalDate.now().plusDays(26));
        emprestimo.setDiasEmAtraso(calcDevolucao(emprestimo.getDiaDevolucao(), emprestimo.getVencimentoDevolucao()));

        emprestimo.setAtraso(verificaAtraso(emprestimo.getVencimentoDevolucao(), emprestimo.getDiaDevolucao()));
        emprestimo.setMulta(calMultaAtraso(emprestimo.getDiasEmAtraso()));

        emprestimoRegistrado.replaceAll(emprestimo1 -> emprestimo);

        return "Devolução recebida!";

    }

    public Integer calcDevolucao(LocalDate diaDevolucao, LocalDate vencimentoDevolucao) {
        int diaDevolucaoInt = diaDevolucao.getDayOfYear();
        int diaEntvencimentoDevolucaoInt = vencimentoDevolucao.getDayOfYear();
        int diasAtraso;

        if (diaDevolucao.isAfter(vencimentoDevolucao)) {
            diasAtraso = diaDevolucaoInt - diaEntvencimentoDevolucaoInt;

            return diasAtraso;
        } else {

            return 0;
        }
    }

    public Boolean verificaAtraso(LocalDate dataDevolucao, LocalDate dataLimite) {
        return (dataDevolucao.isAfter(dataLimite));
    }

    public Float calMultaAtraso(Integer diasAtraso) {
        float valorMultaPorDia = 5.00F;

        return diasAtraso * valorMultaPorDia;
    }
}
