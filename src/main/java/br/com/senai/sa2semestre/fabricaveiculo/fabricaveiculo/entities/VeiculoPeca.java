package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.*;

@Entity
public class VeiculoPeca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = "chassi", referencedColumnName = "chassi" )
    private Veiculo veiculo;
    @ManyToOne
    @JoinColumn(name = "idPecas", referencedColumnName = "idPecas")
    private Peca peca;
    private Long quantidade;

    public VeiculoPeca() {
    }

    public VeiculoPeca(Veiculo veiculo, Peca peca, Long quantidade) {
        this.veiculo = veiculo;
        this.peca = peca;
        this.quantidade = quantidade;
    }

    public Veiculo getVeiculos() {
        return veiculo;
    }

    public void setVeiculos(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Peca getPecas() {
        return peca;
    }

    public void setPecas(Peca peca) {
        this.peca = peca;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
