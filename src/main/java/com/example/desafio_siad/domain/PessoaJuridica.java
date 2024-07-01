package com.example.desafio_siad.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoa_juridica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaJuridica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_juridica_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "dt_nascimento")
    private String dt_nascimento;

    @Column(name = "cnpj")
    private String cnpj;

    @OneToMany
    @JoinTable(name = "pessoa_juridica_produtos", joinColumns = @JoinColumn(name = "pessoa_juridica_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos;
}
