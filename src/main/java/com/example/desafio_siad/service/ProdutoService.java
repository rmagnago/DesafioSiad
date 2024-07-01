package com.example.desafio_siad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio_siad.domain.Produto;
import com.example.desafio_siad.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAllProdutos() {
        return repository.findAll();
    }

    public Optional<Produto> findProdutoById(int id) {
        return repository.findById(id);
    }

    public Produto saveProduto(Produto produto) {
        return repository.save(produto);
    }

    public void deleteProduto(int id) {
        repository.deleteById(id);
    }
}
