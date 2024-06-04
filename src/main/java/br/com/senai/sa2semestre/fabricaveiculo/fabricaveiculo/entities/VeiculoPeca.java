package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "veiculoPeca")
public class VeiculoPeca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVeiculoPecas;
    @ManyToOne
    @JoinColumn(name = "idPeca", referencedColumnName = "idPeca")
    private Peca peca;
    @ManyToOne
    @JoinColumn(name = "chassi", referencedColumnName = "chassi")
    private Veiculo veiculo;
    private Long quantidade;

    public VeiculoPeca() {
    }

    public VeiculoPeca(Long idVeiculoPecas, Peca peca, Veiculo veiculo, Long quantidade) {
        this.idVeiculoPecas = idVeiculoPecas;
        this.peca = peca;
        this.veiculo = veiculo;
        this.quantidade = quantidade;
    }

    public Long getIdVeiculoPecas() {
        return idVeiculoPecas;
    }

    public void setIdVeiculoPecas(Long idVeiculoPecas) {
        this.idVeiculoPecas = idVeiculoPecas;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VeiculoPeca that = (VeiculoPeca) o;

        if (!idVeiculoPecas.equals(that.idVeiculoPecas)) return false;
        if (!Objects.equals(peca, that.peca)) return false;
        if (!Objects.equals(veiculo, that.veiculo)) return false;
        return Objects.equals(quantidade, that.quantidade);
    }

    @Override
    public int hashCode() {
        int result = idVeiculoPecas.hashCode();
        result = 31 * result + (peca != null ? peca.hashCode() : 0);
        result = 31 * result + (veiculo != null ? veiculo.hashCode() : 0);
        result = 31 * result + (quantidade != null ? quantidade.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VeiculoPeca{" +
                "idVeiculoPecas=" + idVeiculoPecas +
                ", peca=" + peca +
                ", veiculo=" + veiculo +
                ", quantidade=" + quantidade +
                '}';
    }
}
