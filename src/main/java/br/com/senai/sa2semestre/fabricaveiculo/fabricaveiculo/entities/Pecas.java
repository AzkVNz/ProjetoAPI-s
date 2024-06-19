package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

/**
 * Representa uma peça no sistema de fabricação de veículos.
 * Esta entidade é mapeada para uma tabela do banco de dados usando anotações JPA.
 * Inclui detalhes como o ID da peça, nome, descrição, quantidade,
 * e relacionamentos com estoque (Estoque), produção (Producao) e veículos (Veiculo).
 */
@Entity
public class Pecas {

    /**
     * Identificador único da peça.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPecas;

    /**
     * Nome da peça.
     */
    private String nome;

    /**
     * Descrição da peça.
     */
    private String descricao;

    /**
     * Quantidade da peça em estoque.
     */
    private Long Quantidade;

    /**
     * Lista de estoques que contêm esta peça.
     */
    @OneToMany(mappedBy = "pecas")
    @JsonIgnore
    private List<Estoque> listaDeEstoque;

    /**
     * Lista de produções que utilizam esta peça.
     */
    @OneToMany(mappedBy = "pecas")
    @JsonIgnore
    private List<Producao> listaDeProducao;

    /**
     * Lista de veículos que utilizam esta peça.
     */
    @ManyToMany(mappedBy = "pecas")
    @JsonIgnore
    private List<Veiculo> veiculos = new ArrayList<>();

    /**
     * Construtor padrão.
     */
    public Pecas() {
    }

    /**
     * Construtor com parâmetros.
     *
     * @param idPecas Identificador da peça.
     * @param nome Nome da peça.
     * @param descricao Descrição da peça.
     * @param quantidade Quantidade da peça.
     * @param listaDeEstoque Lista de estoques.
     * @param listaDeProducao Lista de produções.
     * @param veiculos Lista de veículos.
     */
    public Pecas(Long idPecas, String nome, String descricao, Long quantidade, List<Estoque> listaDeEstoque, List<Producao> listaDeProducao, List<Veiculo> veiculos) {
        this.idPecas = idPecas;
        this.nome = nome;
        this.descricao = descricao;
        this.Quantidade = quantidade;
        this.listaDeEstoque = listaDeEstoque;
        this.listaDeProducao = listaDeProducao;
        this.veiculos = veiculos;
    }

    /**
     * Obtém o identificador da peça.
     *
     * @return O identificador da peça.
     */
    public Long getIdPecas() {
        return idPecas;
    }

    /**
     * Define o identificador da peça.
     *
     * @param idPecas O novo identificador da peça.
     */
    public void setIdPecas(Long idPecas) {
        this.idPecas = idPecas;
    }

    /**
     * Obtém o nome da peça.
     *
     * @return O nome da peça.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da peça.
     *
     * @param nome O novo nome da peça.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a descrição da peça.
     *
     * @return A descrição da peça.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição da peça.
     *
     * @param descricao A nova descrição da peça.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém a quantidade da peça em estoque.
     *
     * @return A quantidade da peça.
     */
    public Long getQuantidade() {
        return Quantidade;
    }

    /**
     * Define a quantidade da peça em estoque.
     *
     * @param quantidade A nova quantidade da peça.
     */
    public void setQuantidade(Long quantidade) {
        this.Quantidade = quantidade;
    }

    /**
     * Obtém a lista de estoques que contêm esta peça.
     *
     * @return A lista de estoques.
     */
    public List<Estoque> getListaDeEstoque() {
        return listaDeEstoque;
    }

    /**
     * Define a lista de estoques que contêm esta peça.
     *
     * @param listaDeEstoque A nova lista de estoques.
     */
    public void setListaDeEstoque(List<Estoque> listaDeEstoque) {
        this.listaDeEstoque = listaDeEstoque;
    }

    /**
     * Obtém a lista de produções que utilizam esta peça.
     *
     * @return A lista de produções.
     */
    public List<Producao> getListaDeProducao() {
        return listaDeProducao;
    }

    /**
     * Define a lista de produções que utilizam esta peça.
     *
     * @param listaDeProducao A nova lista de produções.
     */
    public void setListaDeProducao(List<Producao> listaDeProducao) {
        this.listaDeProducao = listaDeProducao;
    }

    /**
     * Obtém a lista de veículos que utilizam esta peça.
     *
     * @return A lista de veículos.
     */
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    /**
     * Define a lista de veículos que utilizam esta peça.
     *
     * @param veiculos A nova lista de veículos.
     */
    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    /**
     * Verifica se este objeto é igual a outro objeto.
     *
     * @param o O objeto a ser comparado.
     * @return true se os objetos forem iguais; false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pecas pecas = (Pecas) o;

        if (!idPecas.equals(pecas.idPecas)) return false;
        if (!Objects.equals(nome, pecas.nome)) return false;
        if (!Objects.equals(descricao, pecas.descricao)) return false;
        if (!Objects.equals(Quantidade, pecas.Quantidade)) return false;
        if (!Objects.equals(listaDeEstoque, pecas.listaDeEstoque))
            return false;
        if (!Objects.equals(listaDeProducao, pecas.listaDeProducao))
            return false;
        return Objects.equals(veiculos, pecas.veiculos);
    }

    /**
     * Calcula o código hash para o objeto.
     *
     * @return O código hash calculado.
     */
    @Override
    public int hashCode() {
        int result = idPecas.hashCode();
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (Quantidade != null ? Quantidade.hashCode() : 0);
        result = 31 * result + (listaDeEstoque != null ? listaDeEstoque.hashCode() : 0);
        result = 31 * result + (listaDeProducao != null ? listaDeProducao.hashCode() : 0);
        result = 31 * result + (veiculos != null ? veiculos.hashCode() : 0);
        return result;
    }

    /**
     * Retorna a representação em string do objeto.
     *
     * @return A representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Pecas{" +
                "idPecas=" + idPecas +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", Quantidade=" + Quantidade +
                ", listaDeEstoque=" + listaDeEstoque +
                ", listaDeProducao=" + listaDeProducao +
                ", veiculos=" + veiculos +
                '}';
    }
}
