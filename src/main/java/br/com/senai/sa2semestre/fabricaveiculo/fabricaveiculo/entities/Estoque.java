package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * Representa o estoque de peças.
 */
@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstoque;

    @ManyToOne
    @JoinColumn(name = "idPecas", referencedColumnName = "idPecas")
    private Pecas pecas;

    private Long quantidadeDisponivel;

    /**
     * Construtor padrão.
     */
    public Estoque() {
    }

    /**
     * Construtor com parâmetros.
     *
     * @param idEstoque O ID do estoque.
     * @param pecas A peça associada ao estoque.
     * @param quantidadeDisponivel A quantidade disponível em estoque.
     */
    public Estoque(Long idEstoque, Pecas pecas, Long quantidadeDisponivel) {
        this.idEstoque = idEstoque;
        this.pecas = pecas;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    /**
     * Obtém o ID do estoque.
     *
     * @return o ID do estoque.
     */
    public Long getIdEstoque() {
        return idEstoque;
    }

    /**
     * Define o ID do estoque.
     *
     * @param idEstoque o ID do estoque.
     */
    public void setIdEstoque(Long idEstoque) {
        this.idEstoque = idEstoque;
    }

    /**
     * Obtém a peça associada ao estoque.
     *
     * @return a peça associada ao estoque.
     */
    public Pecas getPecas() {
        return pecas;
    }

    /**
     * Define a peça associada ao estoque.
     *
     * @param pecas a peça associada ao estoque.
     */
    public void setPecas(Pecas pecas) {
        this.pecas = pecas;
    }

    /**
     * Obtém a quantidade disponível em estoque.
     *
     * @return a quantidade disponível em estoque.
     */
    public Long getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    /**
     * Define a quantidade disponível em estoque.
     *
     * @param quantidadeDisponivel a quantidade disponível em estoque.
     */
    public void setQuantidadeDisponivel(Long quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    /**
     * Verifica se este objeto é igual a outro objeto.
     *
     * @param o o objeto a ser comparado.
     * @return true se os objetos são iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return Objects.equals(idEstoque, estoque.idEstoque) &&
                Objects.equals(pecas, estoque.pecas) &&
                Objects.equals(quantidadeDisponivel, estoque.quantidadeDisponivel);
    }

    /**
     * Retorna o valor de hash do objeto.
     *
     * @return o valor de hash do objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idEstoque, pecas, quantidadeDisponivel);
    }

    /**
     * Retorna a representação em string do objeto.
     *
     * @return a representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Estoque{" +
                "idEstoque=" + idEstoque +
                ", pecas=" + pecas +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                '}';
    }
}
