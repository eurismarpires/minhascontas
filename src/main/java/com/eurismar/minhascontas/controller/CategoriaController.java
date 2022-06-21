package com.eurismar.minhascontas.controller;

import com.eurismar.minhascontas.controller.dto.CategoriaDto;
import com.eurismar.minhascontas.controller.form.CategoriaForm;
import com.eurismar.minhascontas.modelo.Categoria;
import com.eurismar.minhascontas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;


    @GetMapping
    public List<CategoriaDto> lista() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return CategoriaDto.converter(categorias);
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form, UriComponentsBuilder uriBuilder) {
        Categoria categoria = form.converter(categoriaRepository);
        categoriaRepository.save(categoria);
        URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CategoriaDto> editar(@PathVariable Long id,  @RequestBody @Valid CategoriaForm form){
        Categoria categoria = form.editar(id, categoriaRepository);
        System.out.println(" a nova categoria é " + form.getNome());
        return ResponseEntity.ok(new CategoriaDto(categoria));
    }
}
