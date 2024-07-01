package com.example.desafio_siad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio_siad.domain.Venda;
import com.example.desafio_siad.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public List<Venda> findAllVendas() {
        return repository.findAll();
    }

    public Optional<Venda> findVendaById(int id) {
        return repository.findById(id);
    }

    public Venda saveVenda(Venda venda) {
        return repository.save(venda);
    }

    public void deleteVenda(int id) {
        repository.deleteById(id);
    }
}
