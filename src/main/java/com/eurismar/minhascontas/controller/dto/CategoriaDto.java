package com.eurismar.minhascontas.controller.dto;

import com.eurismar.minhascontas.modelo.Categoria;
import com.eurismar.minhascontas.modelo.Conta;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDto {
    private Long id;
    private String nome;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public static List<CategoriaDto> converter(List<Categoria> categorias) {
        return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
    }
}
