package com.example.desafio_siad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.desafio_siad.domain.Venda;
import com.example.desafio_siad.repository.VendaRepository;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaRepository repository;

    @GetMapping
    public List<Venda> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Venda> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Venda save(@RequestBody Venda venda) {
        return repository.save(venda);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Venda> updatePessoa(@PathVariable Long id, @RequestBody Venda venda) {
        Optional<Venda> vendaExistente = repository.findById(id);

        if (vendaExistente.isPresent()) {
            Venda novaVenda = vendaExistente.get();
            novaVenda.setTotal(venda.getTotal());
            novaVenda.setQt(venda.getQt());

            repository.save(novaVenda);
            return ResponseEntity.ok().body(novaVenda);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
