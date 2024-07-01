package com.example.desafio_siad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.desafio_siad.domain.Endereco;
import com.example.desafio_siad.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    @GetMapping
    public List<Endereco> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Endereco> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Endereco save(@RequestBody Endereco end) {
        return repository.save(end);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Endereco> updatePessoa(@PathVariable Long id, @RequestBody Endereco end) {
        Optional<Endereco> enderecoExistente = repository.findById(id);

        if (enderecoExistente.isPresent()) {
            Endereco novoEndereco = enderecoExistente.get();
            novoEndereco.setCidade(end.getCidade());
            novoEndereco.setBairro(end.getCidade());
            novoEndereco.setRua(end.getRua());
            novoEndereco.setBairro(end.getBairro());
            novoEndereco.setNumero(end.getNumero());

            repository.save(novoEndereco);
            return ResponseEntity.ok().body(novoEndereco);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
