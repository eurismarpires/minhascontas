package com.eurismar.minhascontas.controller.form;

import com.eurismar.minhascontas.modelo.Categoria;
import com.eurismar.minhascontas.modelo.Conta;
import com.eurismar.minhascontas.repository.CategoriaRepository;
import com.eurismar.minhascontas.repository.ContaRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CategoriaForm {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converter(CategoriaRepository categoriaRepository) {
        // Categoria categoria = categoriaRepository.findByNome(nome);
        return new Categoria(nome);
    }
    public Categoria editar(Long id, CategoriaRepository categoriaRepository){
        Categoria categoria = categoriaRepository.getOne(id);
        categoria.setNome(this.nome);
        System.out.println(" atualizou a categoria: " + this.nome);
        return categoria;
    }
}
