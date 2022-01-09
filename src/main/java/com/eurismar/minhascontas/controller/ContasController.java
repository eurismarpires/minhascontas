package com.eurismar.minhascontas.controller;

import com.eurismar.minhascontas.controller.dto.ContaDto;
import com.eurismar.minhascontas.controller.form.ContaForm;
import com.eurismar.minhascontas.modelo.Conta;
import com.eurismar.minhascontas.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/contas")
public class ContasController {

    @Autowired
    private ContaRepository contaRepository;

    @GetMapping
    public List<ContaDto> lista(){
        List<Conta> contas = contaRepository.findAll();
        return ContaDto.converter(contas);
    }
    @PostMapping
    public ResponseEntity<ContaDto> cadastrar(@RequestBody ContaForm form, UriComponentsBuilder uriBuilder){
        System.out.println("chegou até aqui");
        Conta  conta = form.converter(contaRepository);
        contaRepository.save(conta);
        URI uri = uriBuilder.path("/contas/{id}").buildAndExpand(conta.getId()).toUri();
        return ResponseEntity.created(uri).body(new ContaDto(conta));
    }
}
