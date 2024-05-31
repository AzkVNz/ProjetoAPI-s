package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.*;

@Entity
public class VeiculosPecas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = "chassi", referencedColumnName = "chassi" )
    private Veiculos veiculos;
    @ManyToOne
    @JoinColumn(name = "idPecas", referencedColumnName = "idPecas")
    private Pecas pecas;
    private Long quantidade;

    public VeiculosPecas() {
    }

    public VeiculosPecas(Veiculos veiculos, Pecas pecas, Long quantidade) {
        this.veiculos = veiculos;
        this.pecas = pecas;
        this.quantidade = quantidade;
    }

    public Veiculos getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Veiculos veiculos) {
        this.veiculos = veiculos;
    }

    public Pecas getPecas() {
        return pecas;
    }

    public void setPecas(Pecas pecas) {
        this.pecas = pecas;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
