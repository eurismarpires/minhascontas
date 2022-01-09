package com.eurismar.minhascontas.controller.dto;

import com.eurismar.minhascontas.modelo.Categoria;
import com.eurismar.minhascontas.modelo.Conta;
import com.eurismar.minhascontas.modelo.Tipo;
import com.eurismar.minhascontas.modelo.Transacao;
import com.eurismar.minhascontas.repository.TransacaoRepository;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TransacaoDto {
    private Long id;
    private String descricao;
    private Double valor;
    private LocalDate data;

    public TransacaoDto(Transacao transacao) {
        this.id = transacao.getId();
        this.descricao = transacao.getDescricao();
        this.valor = transacao.getValor();
        this.data = transacao.getData();
    }

    public static List<TransacaoDto> converter(List<Transacao> transacoes) {
        return transacoes.stream().map(TransacaoDto::new).collect(Collectors.toList());

    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }
}
