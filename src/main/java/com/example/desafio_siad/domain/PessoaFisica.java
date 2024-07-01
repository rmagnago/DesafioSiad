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
@Table(name = "pessoa_fisica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_fisica_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "dt_nascimento")
    private String dt_nascimento;

    @Column(name = "cpf")
    private String cpf;

    @OneToMany
    @JoinTable(name = "pessoa_fisica_vendas", joinColumns = @JoinColumn(name = "pessoa_fisica_id"), inverseJoinColumns = @JoinColumn(name = "venda_id"))
    private List<Venda> vendas;

    @OneToMany
    @JoinTable(name = "pessoa_fisica_enderecos", joinColumns = @JoinColumn(name = "pessoa_fisica_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private List<Endereco> enderecos;
}
