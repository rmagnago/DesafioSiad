package com.example.desafio_siad.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "venda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venda_id")
    private int id;

    @Column(name = "total")
    private double total;

    @Column(name = "qt")
    private int qt;

    @ManyToOne
    @JoinColumn(name = "pessoa_fisica_id")
    private PessoaFisica pessoa;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}
