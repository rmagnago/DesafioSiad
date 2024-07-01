package com.example.desafio_siad.domain;

import java.util.List;

import jakarta.persistence.*;
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
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dt_nascimento")
    private String dt_nascimento;

    @Column(name = "cnpj")
    private String cnpj;

    @OneToMany(mappedBy = "pessoaJuridica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produto> produtos;
}
