package com.example.desafio_siad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio_siad.domain.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

}
