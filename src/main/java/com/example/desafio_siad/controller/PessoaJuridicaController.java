package com.example.desafio_siad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio_siad.domain.PessoaJuridica;
import com.example.desafio_siad.domain.Produto;
import com.example.desafio_siad.repository.PessoaJuridicaRepository;

@RestController
@RequestMapping("/pessoa_juridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaRepository repository;

    @GetMapping
    public List<PessoaJuridica> findAllJuridicas() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<PessoaJuridica> findJuridicaById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public PessoaJuridica saveJuridica(@RequestBody PessoaJuridica pessoa) {
        return repository.save(pessoa);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaJuridica> updatePessoa(@PathVariable Long id, @RequestBody PessoaJuridica p) {
        Optional<PessoaJuridica> pessoaExistente = repository.findById(id);

        if (pessoaExistente.isPresent()) {
            PessoaJuridica novaPessoa = pessoaExistente.get();
            novaPessoa.setName(p.getName());
            novaPessoa.setDt_nascimento(p.getDt_nascimento());
            novaPessoa.setCnpj(p.getCnpj());

            if (p.getProdutos() != null) {
                novaPessoa.getProdutos().clear();

                for (Produto produto : p.getProdutos()) {
                    produto.setPessoaJuridica(novaPessoa);
                    novaPessoa.getProdutos().add(produto);
                }
            }

            repository.save(novaPessoa);
            return ResponseEntity.ok().body(novaPessoa);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deletePessoa(@PathVariable Long id) {
        repository.deleteById(id);
    }

}