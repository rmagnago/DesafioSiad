package com.example.desafio_siad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio_siad.service.PessoaJuridicaService;

@RestController
@RequestMapping("/pessoa_juridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService service;

    @GetMapping
    public ResponseEntity getJurificos() {
        
        return ResponseEntity.ok("Retorn pessoas juridicas");
    }

    @PostMapping
    public ResponseEntity postJuridicos() {
        return null;
    }

    @PutMapping
    public ResponseEntity putJuridicos() {
        return null;
    }

    @DeleteMapping
    public ResponseEntity deleteJuridicos() {
        return null;
    }
}
