package com.example.desafio_siad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio_siad.domain.PessoaFisica;
import com.example.desafio_siad.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository repository;

    public List<PessoaFisica> findAllFisicas() {
        return repository.findAll();
    }

    public Optional<PessoaFisica> findPessoaFisicaById(int id) {
        return repository.findById(id);
    }

    public PessoaFisica saveFisica(PessoaFisica pessoa) {
        return repository.save(pessoa);
    }

    public void deleteFisica(int id) {
        repository.deleteById(id);
    }
}
