package com.example.desafio_siad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio_siad.domain.Endereco;
import com.example.desafio_siad.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public List<Endereco> findAllEnderecos() {
        return repository.findAll();
    }

    public Optional<Endereco> findEnderecoById(int id) {
        return repository.findById(id);
    }

    public Endereco saveEndereco(Endereco end) {
        return repository.save(end);
    }

    public void deleteEndereco(int id) {
        repository.deleteById(id);
    }
}
