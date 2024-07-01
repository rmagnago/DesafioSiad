package com.example.desafio_siad.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private double valor;

    @ManyToOne
    @JoinColumn(name = "pessoa_juridica_id")
    private PessoaJuridica pessoa;

    @OneToMany
    @JoinTable(name = "produto_vendas", joinColumns = @JoinColumn(name = "produtos_id"), inverseJoinColumns = @JoinColumn(name = "venda_id"))
    private List<Venda> vendas;
}
