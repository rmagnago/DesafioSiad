package com.example.desafio_siad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.desafio_siad.domain.Endereco;
import com.example.desafio_siad.domain.PessoaFisica;
import com.example.desafio_siad.repository.PessoaFisicaRepository;

@RestController
@RequestMapping("/pessoa_fisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaRepository repository;

    @GetMapping
    public List<PessoaFisica> findAllFisicas() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<PessoaFisica> findPessoaFisicaById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public PessoaFisica saveFisica(@RequestBody PessoaFisica pessoa) {
        return repository.save(pessoa);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaFisica> updatePessoa(@PathVariable Long id, @RequestBody PessoaFisica p) {
        Optional<PessoaFisica> pessoaExistente = repository.findById(id);

        if (pessoaExistente.isPresent()) {
            PessoaFisica novaPessoa = pessoaExistente.get();
            novaPessoa.setName(p.getName());
            novaPessoa.setDt_nascimento(p.getDt_nascimento());
            novaPessoa.setCpf(p.getCpf());

            if (p.getEnderecos() != null) {
                novaPessoa.getEnderecos().clear();

                for (Endereco endereco : p.getEnderecos()) {
                    endereco.setPessoaFisica(novaPessoa);
                    novaPessoa.getEnderecos().add(endereco);
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
