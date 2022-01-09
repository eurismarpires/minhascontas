package com.eurismar.minhascontas.repository;

import com.eurismar.minhascontas.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    public Categoria findByNome(String nome);
}
