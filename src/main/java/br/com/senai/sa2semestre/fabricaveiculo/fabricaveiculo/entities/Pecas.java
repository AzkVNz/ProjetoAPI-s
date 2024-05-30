package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Pecas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iDPeca;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "estoque")
    private List<Estoque> listaDeEstoque;
    @OneToMany(mappedBy = "veiculosPecas")
    private List<VeiculosPecas> listaDeVeiculoPecas;
    @OneToMany(mappedBy = "producao")
    private List<Producao> listaDeProducao;

    public Pecas() {
    }

    public Pecas(Long iDPecas, String nome, String descricao, List<Estoque> listaDeEstoque, List<VeiculosPecas> listaDeVeiculoPecas, List<Producao> listaDeProducao) {
        this.iDPeca = iDPecas;
        this.nome = nome;
        this.descricao = descricao;
        this.listaDeEstoque = listaDeEstoque;
        this.listaDeVeiculoPecas = listaDeVeiculoPecas;
        this.listaDeProducao = listaDeProducao;
    }

    public Long getiIDPeca() {
        return iDPeca;
    }

    public void setiIDPeca(Long iDPecas) {
        this.iDPeca = iDPecas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Estoque> getListaDeEstoque() {
        return listaDeEstoque;
    }

    public void setListaDeEstoque(List<Estoque> listaDeEstoque) {
        this.listaDeEstoque = listaDeEstoque;
    }

    public List<VeiculosPecas> getListaDeVeiculoPecas() {
        return listaDeVeiculoPecas;
    }

    public void setListaDeVeiculoPecas(List<VeiculosPecas> listaDeVeiculoPecas) {
        this.listaDeVeiculoPecas = listaDeVeiculoPecas;
    }

    public List<Producao> getListaDeProducao() {
        return listaDeProducao;
    }

    public void setListaDeProducao(List<Producao> listaDeProducao) {
        this.listaDeProducao = listaDeProducao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pecas pecas = (Pecas) o;

        if (!iDPeca.equals(pecas.iDPeca)) return false;
        if (!Objects.equals(nome, pecas.nome)) return false;
        if (!Objects.equals(descricao, pecas.descricao)) return false;
        if (!Objects.equals(listaDeEstoque, pecas.listaDeEstoque))
            return false;
        if (!Objects.equals(listaDeVeiculoPecas, pecas.listaDeVeiculoPecas))
            return false;
        return Objects.equals(listaDeProducao, pecas.listaDeProducao);
    }

    @Override
    public int hashCode() {
        int result = iDPeca.hashCode();
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (listaDeEstoque != null ? listaDeEstoque.hashCode() : 0);
        result = 31 * result + (listaDeVeiculoPecas != null ? listaDeVeiculoPecas.hashCode() : 0);
        result = 31 * result + (listaDeProducao != null ? listaDeProducao.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pecas{" +
                "iDPecas=" + iDPeca +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", listaDeEstoque=" + listaDeEstoque +
                ", listaDeVeiculoPecas=" + listaDeVeiculoPecas +
                ", listaDeProducao=" + listaDeProducao +
                '}';
    }
}
