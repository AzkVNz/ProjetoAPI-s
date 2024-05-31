package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Peca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPecas;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "peca")
    private List<Estoque> listaDeEstoque;
    @OneToMany(mappedBy = "peca")
    private List<VeiculoPeca> listaDeVeiculoPecas;
    @OneToMany(mappedBy = "peca")
    private List<Producao> listaDeProducao;

    public Peca() {
    }

    public Peca(Long iDPecas, String nome, String descricao, List<Estoque> listaDeEstoque, List<VeiculoPeca> listaDeVeiculoPecas, List<Producao> listaDeProducao) {
        this.idPecas = iDPecas;
        this.nome = nome;
        this.descricao = descricao;
        this.listaDeEstoque = listaDeEstoque;
        this.listaDeVeiculoPecas = listaDeVeiculoPecas;
        this.listaDeProducao = listaDeProducao;
    }

    public Long getiIDPeca() {
        return idPecas;
    }

    public void setiIDPeca(Long iDPecas) {
        this.idPecas = iDPecas;
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

    public List<VeiculoPeca> getListaDeVeiculoPecas() {
        return listaDeVeiculoPecas;
    }

    public void setListaDeVeiculoPecas(List<VeiculoPeca> listaDeVeiculoPecas) {
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

        Peca peca = (Peca) o;

        if (!idPecas.equals(peca.idPecas)) return false;
        if (!Objects.equals(nome, peca.nome)) return false;
        if (!Objects.equals(descricao, peca.descricao)) return false;
        if (!Objects.equals(listaDeEstoque, peca.listaDeEstoque))
            return false;
        if (!Objects.equals(listaDeVeiculoPecas, peca.listaDeVeiculoPecas))
            return false;
        return Objects.equals(listaDeProducao, peca.listaDeProducao);
    }

    @Override
    public int hashCode() {
        int result = idPecas.hashCode();
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
                "iDPecas=" + idPecas +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", listaDeEstoque=" + listaDeEstoque +
                ", listaDeVeiculoPecas=" + listaDeVeiculoPecas +
                ", listaDeProducao=" + listaDeProducao +
                '}';
    }
}
