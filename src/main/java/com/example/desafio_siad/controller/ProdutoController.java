package com.example.desafio_siad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.desafio_siad.domain.Produto;
import com.example.desafio_siad.domain.Venda;
import com.example.desafio_siad.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produto> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Produto> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Produto save(@RequestBody Produto prod) {
        return repository.save(prod);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> updatePessoa(@PathVariable Long id, @RequestBody Produto prod) {
        Optional<Produto> produtoExistente = repository.findById(id);

        if (produtoExistente.isPresent()) {
            Produto novoProduto = produtoExistente.get();
            novoProduto.setNome(prod.getNome());
            novoProduto.setValor(prod.getValor());

            if (prod.getVendas() != null) {
                novoProduto.getVendas().clear();

                for (Venda venda : prod.getVendas()) {
                    venda.setProduto(novoProduto);
                    novoProduto.getVendas().add(venda);
                }
            }

            repository.save(novoProduto);
            return ResponseEntity.ok().body(novoProduto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
