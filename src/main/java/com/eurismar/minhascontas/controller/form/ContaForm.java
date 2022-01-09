package com.eurismar.minhascontas.controller.form;

import com.eurismar.minhascontas.modelo.Conta;
import com.eurismar.minhascontas.repository.ContaRepository;

public class ContaForm {

    private String nome;
    public Conta converter(ContaRepository contaRepository) {
        Conta conta = contaRepository.findByNome(nome);
        return new Conta(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
