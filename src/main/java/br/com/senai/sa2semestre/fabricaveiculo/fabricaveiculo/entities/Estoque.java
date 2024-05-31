package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstoque;
    @ManyToOne
    @JoinColumn(name = "idPecas", referencedColumnName = "idPecas")
    private Peca peca;
    private Long quantidadeDisponivel;

    public Estoque() {
    }

    public Estoque(Long iDEstoque, Peca peca, Long quantidadeDisponivel) {
        this.idEstoque = iDEstoque;
        this.peca = peca;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Long getiDEstoque() {
        return idEstoque;
    }

    public void setiDEstoque(Long iDEstoque) {
        this.idEstoque = iDEstoque;
    }

    public Peca getPecas() {
        return peca;
    }

    public void setPecas(Peca peca) {
        this.peca = peca;
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

        if (!idEstoque.equals(estoque.idEstoque)) return false;
        if (!Objects.equals(peca, estoque.peca)) return false;
        return Objects.equals(quantidadeDisponivel, estoque.quantidadeDisponivel);
    }

    @Override
    public int hashCode() {
        int result = idEstoque.hashCode();
        result = 31 * result + (peca != null ? peca.hashCode() : 0);
        result = 31 * result + (quantidadeDisponivel != null ? quantidadeDisponivel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "iDEstoque=" + idEstoque +
                ", pecas=" + peca +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                '}';
    }
}
