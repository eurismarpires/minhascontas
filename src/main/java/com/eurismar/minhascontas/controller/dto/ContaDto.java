package com.eurismar.minhascontas.controller.dto;

import com.eurismar.minhascontas.modelo.Conta;

import java.util.List;
import java.util.stream.Collectors;

public class ContaDto {
    private Long id;
    private String nome;
    private Double saldoInicial;

    public ContaDto(Conta conta) {
        this.id = conta.getId();
        this.nome = conta.getNome();
        this.saldoInicial = conta.getSaldoInicial();
    }

    public static List<ContaDto> converter(List<Conta> contas) {
        return contas.stream().map(ContaDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }
}
