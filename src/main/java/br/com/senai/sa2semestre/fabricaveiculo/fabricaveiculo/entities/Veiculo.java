package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Veiculo {
    @Id
    private String chassi;
    private String modelo;
    private Long ano;
    private String cor;

    @OneToMany(mappedBy = "veiculo")
    private List<VeiculoPeca> listDeVeiculoPeca;

    public Veiculo() {
    }

    public Veiculo(String chassi, String modelo, Long ano, String cor, List<VeiculoPeca> listDeVeiculoPeca) {
        this.chassi = chassi;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.listDeVeiculoPeca = listDeVeiculoPeca;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<VeiculoPeca> getListDeVeiculoPeca() {
        return listDeVeiculoPeca;
    }

    public void setListDeVeiculoPeca(List<VeiculoPeca> listDeVeiculosPeca) {
        this.listDeVeiculoPeca = listDeVeiculosPeca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Veiculo veiculo = (Veiculo) o;

        if (!chassi.equals(veiculo.chassi)) return false;
        if (!Objects.equals(modelo, veiculo.modelo)) return false;
        if (!Objects.equals(ano, veiculo.ano)) return false;
        if (!Objects.equals(cor, veiculo.cor)) return false;
        return Objects.equals(listDeVeiculoPeca, veiculo.listDeVeiculoPeca);
    }

    @Override
    public int hashCode() {
        int result = chassi.hashCode();
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        result = 31 * result + (ano != null ? ano.hashCode() : 0);
        result = 31 * result + (cor != null ? cor.hashCode() : 0);
        result = 31 * result + (listDeVeiculoPeca != null ? listDeVeiculoPeca.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Veiculos{" +
                "chassi='" + chassi + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                ", listDeVeiculosPecas=" + listDeVeiculoPeca +
                '}';
    }
}
