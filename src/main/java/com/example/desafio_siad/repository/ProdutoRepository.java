package com.example.desafio_siad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio_siad.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
