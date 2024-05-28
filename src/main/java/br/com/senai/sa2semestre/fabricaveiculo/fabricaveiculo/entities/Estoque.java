package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.*;

@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idEstoque;
    @ManyToOne
    @JoinColumn (name = "idPeca", referencedColumnName = "idPeca")
    private Pecas pecas;
    private Long quantidadeDisponivel;
    public Estoque() {
    }



}
