package com.example.desafio_siad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio_siad.domain.PessoaJuridica;
import com.example.desafio_siad.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository repository;

    public List<PessoaJuridica> findAllJuridicas() {
        return repository.findAll();
    }

    public Optional<PessoaJuridica> findPessoaJuridicaById(int id) {
        return repository.findById(id);
    }

    public PessoaJuridica saveJuridica(PessoaJuridica pessoa) {
        return repository.save(pessoa);
    }

    public void deleteJuridica(int id) {
        repository.deleteById(id);
    }
}
