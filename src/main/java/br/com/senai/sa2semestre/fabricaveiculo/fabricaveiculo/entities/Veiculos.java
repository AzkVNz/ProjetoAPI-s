package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Veiculos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String chassi;
    private String modelo;
    private Long ano;
    private String cor;

    @OneToMany(mappedBy = "veiculos")
    private List<VeiculosPecas> listDeVeiculosPecas;

    public Veiculos() {
    }

    public Veiculos(String chassi, String modelo, Long ano, String cor, List<VeiculosPecas> listDeVeiculosPecas) {
        this.chassi = chassi;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.listDeVeiculosPecas = listDeVeiculosPecas;
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

    public List<VeiculosPecas> getListDeVeiculosPecas() {
        return listDeVeiculosPecas;
    }

    public void setListDeVeiculosPecas(List<VeiculosPecas> listDeVeiculosPecas) {
        this.listDeVeiculosPecas = listDeVeiculosPecas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Veiculos veiculos = (Veiculos) o;

        if (!chassi.equals(veiculos.chassi)) return false;
        if (!Objects.equals(modelo, veiculos.modelo)) return false;
        if (!Objects.equals(ano, veiculos.ano)) return false;
        if (!Objects.equals(cor, veiculos.cor)) return false;
        return Objects.equals(listDeVeiculosPecas, veiculos.listDeVeiculosPecas);
    }

    @Override
    public int hashCode() {
        int result = chassi.hashCode();
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        result = 31 * result + (ano != null ? ano.hashCode() : 0);
        result = 31 * result + (cor != null ? cor.hashCode() : 0);
        result = 31 * result + (listDeVeiculosPecas != null ? listDeVeiculosPecas.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Veiculos{" +
                "chassi='" + chassi + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                ", listDeVeiculosPecas=" + listDeVeiculosPecas +
                '}';
    }
}
