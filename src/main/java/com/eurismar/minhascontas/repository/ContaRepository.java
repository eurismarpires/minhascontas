package com.eurismar.minhascontas.repository;

import com.eurismar.minhascontas.modelo.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    public Conta findByNome(String nome);
}
