package com.eurismar.minhascontas.controller;

import com.eurismar.minhascontas.controller.dto.TransacaoDto;
import com.eurismar.minhascontas.modelo.Transacao;
import com.eurismar.minhascontas.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacaoController {
    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping
    public List<TransacaoDto> lista() {
        List<Transacao> transacoes = transacaoRepository.findAll();
        return TransacaoDto.converter(transacoes);
    }
}
