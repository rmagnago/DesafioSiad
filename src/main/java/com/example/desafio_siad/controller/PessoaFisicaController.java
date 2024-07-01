package com.example.desafio_siad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.desafio_siad.domain.PessoaFisica;
import com.example.desafio_siad.service.PessoaFisicaService;

@RestController
@RequestMapping("/pessoa_fisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaFisica>> getAllPessoas() {
        List<PessoaFisica> pessoas = pessoaService.findAllFisicas();
        return ResponseEntity.ok().body(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaFisica> getPessoaById(@PathVariable Integer id) {
        Optional<PessoaFisica> pessoa = pessoaService.findPessoaFisicaById(id);
        return pessoa.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PessoaFisica> createPessoa(@RequestBody PessoaFisica pessoa) {
        PessoaFisica createdPessoa = pessoaService.saveFisica(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaFisica> updatePessoa(@PathVariable Integer id,
            @RequestBody PessoaFisica pessoaDetails) {
        Optional<PessoaFisica> pessoa = pessoaService.findPessoaFisicaById(id);
        if (pessoa.isPresent()) {
            PessoaFisica updatedPessoa = pessoa.get();
            updatedPessoa.setName(pessoaDetails.getName());
            updatedPessoa.setDt_nascimento(pessoaDetails.getDt_nascimento());
            updatedPessoa.setCpf(pessoaDetails.getCpf());
            updatedPessoa.setVendas(pessoaDetails.getVendas());
            updatedPessoa.setEnderecos(pessoaDetails.getEnderecos());

            PessoaFisica savedPessoa = pessoaService.saveFisica(updatedPessoa);
            return ResponseEntity.ok().body(savedPessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Integer id) {
        Optional<PessoaFisica> pessoa = pessoaService.findPessoaFisicaById(id);
        if (pessoa.isPresent()) {
            pessoaService.deleteFisica(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
