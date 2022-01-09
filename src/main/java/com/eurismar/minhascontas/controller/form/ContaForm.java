package com.eurismar.minhascontas.controller.form;

import com.eurismar.minhascontas.modelo.Conta;
import com.eurismar.minhascontas.repository.ContaRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ContaForm {

    @NotNull @Min(5)
    private String nome;
    private Double saldoInicial;

    public Conta converter(ContaRepository contaRepository) {
        // Conta conta = contaRepository.findByNome(nome);
        return new Conta(nome, saldoInicial);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
}
