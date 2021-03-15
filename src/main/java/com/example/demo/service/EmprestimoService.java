package com.example.demo.service;

import com.example.demo.model.Banca;
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
        BancaService bancaService;

    List<Emprestimo> emprestimos = new ArrayList<>();

    public String registraEmprestimo(Map<String, Object> json) {
        Usuario usuario = usuarioService.usuarios.get((Integer) json.get("idUsuario"));
        Banca banca = bancaService.banca.get((Integer) json.get("idBanca"));
        Emprestimo emprestimo = new Emprestimo();

        if (usuario.getQtdEmprestimo() >= 2) {

            return "Não é possível fazer mais que 2 empréstimos!";
        } else if (verificaSeExisteAlgumItemEmAtraso(usuario)){

            return "Existe pendências em seu cadastro. Faça a devolução do seu último empréstimo para regularizar.";
        } else if (verificaSeMultaEstaPendente(usuario)) {

            return "Existe pendências em seu cadastro. Faça a regularização com o financeiro.";
        } else {
            emprestimo.setUsuario(usuario);
            emprestimo.setLivro(banca);
            emprestimo.setDataEmprestimo(LocalDate.now());
            emprestimo.setVencimentoDevolucao(LocalDate.now().plusDays(10));
            emprestimo.setMultaPendente(false);

            usuario.setQtdEmprestimo(contadorDeEmprestimos(usuario.getQtdEmprestimo()));
            emprestimos.add(emprestimo);

            return "Emprestimo realizado com seucesso!";
        }
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public Boolean verificaSeExisteAlgumItemEmAtraso(Usuario usuario) {
        LocalDate dataAtual = LocalDate.now();
        boolean existeAtraso = false;

        for (int x=0; x<emprestimos.size(); x++) {
            Emprestimo emprestimo = emprestimos.get(x);
            if (emprestimo.getUsuario().equals(usuario)) {
                if (emprestimo.getVencimentoDevolucao().isBefore(dataAtual)) {
                    existeAtraso = true;
                }
            }
        }
        return existeAtraso;
    }

    public Boolean verificaSeMultaEstaPendente(Usuario usuario) {
        boolean multaPendete = false;

        for (int x=0; x<emprestimos.size(); x++) {
            Emprestimo emprestimo = emprestimos.get(x);
            if (emprestimo.getUsuario().equals(usuario)) {
                if (emprestimo.getMultaPendente()) {
                    multaPendete = true;
                }
            }
        }
        return multaPendete;
    }

    public Integer contadorDeEmprestimos(Integer qtdEmprestimo) {
        return qtdEmprestimo +1;
    }

    public String devolucaoEmprestimo(Map<String, Object> json) {
        Usuario usuario = usuarioService.usuarios.get((Integer) json.get("idUsuario"));
        Emprestimo emprestimo = emprestimos.get((Integer) json.get("idEmprestimo"));

        emprestimo.setDiaDevolucao(LocalDate.now().plusDays(26));
        emprestimo.setDiasEmAtraso(calcDevolucao(emprestimo.getDiaDevolucao(), emprestimo.getVencimentoDevolucao()));
        emprestimo.setDevolucaoEmAtraso(verificaAtraso(emprestimo.getDiaDevolucao(), emprestimo.getVencimentoDevolucao()));
        emprestimo.setMultaAtrado(calMultaAtraso(emprestimo.getDiasEmAtraso()));
        emprestimo.setMultaPendente(verificaAtraso(emprestimo.getDiaDevolucao(), emprestimo.getVencimentoDevolucao()));

        usuario.setQtdEmprestimo(baixaDeEmprestimos(usuario.getQtdEmprestimo()));

        emprestimos.replaceAll(emprestimo1 -> emprestimo);

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

    public Boolean verificaAtraso(LocalDate dataDevolucao, LocalDate vencimentoDevolucao) {
        return (dataDevolucao.isAfter(vencimentoDevolucao));
    }

    public Float calMultaAtraso(Integer diasAtraso) {
        float valorMultaPorDia = 5.00F;
        return diasAtraso * valorMultaPorDia;
    }

    public Emprestimo regularizaMulta(Map<String, Object> json) {
        Emprestimo emprestimo = emprestimos.get((Integer) json.get("idEmprestimo"));

        emprestimo.setMultaPendente(false);
        emprestimos.replaceAll(emprestimo1 -> emprestimo);

        return emprestimo;
    }

    public Integer baixaDeEmprestimos(Integer qtdEmprestimo) {
        return qtdEmprestimo -1;
    }

}
