package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iDEstoque;
    @ManyToOne
    @JoinColumn(name = "idPeca", referencedColumnName = "idPeca")
    private Pecas pecas;
    private Long quantidadeDisponivel;

    public Estoque() {
    }

    public Estoque(Long iDEstoque, Pecas pecas, Long quantidadeDisponivel) {
        this.iDEstoque = iDEstoque;
        this.pecas = pecas;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Long getiDEstoque() {
        return iDEstoque;
    }

    public void setiDEstoque(Long iDEstoque) {
        this.iDEstoque = iDEstoque;
    }

    public Pecas getPecas() {
        return pecas;
    }

    public void setPecas(Pecas pecas) {
        this.pecas = pecas;
    }

    public Long getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Long quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estoque estoque = (Estoque) o;

        if (!iDEstoque.equals(estoque.iDEstoque)) return false;
        if (!Objects.equals(pecas, estoque.pecas)) return false;
        return Objects.equals(quantidadeDisponivel, estoque.quantidadeDisponivel);
    }

    @Override
    public int hashCode() {
        int result = iDEstoque.hashCode();
        result = 31 * result + (pecas != null ? pecas.hashCode() : 0);
        result = 31 * result + (quantidadeDisponivel != null ? quantidadeDisponivel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "iDEstoque=" + iDEstoque +
                ", pecas=" + pecas +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                '}';
    }
}
