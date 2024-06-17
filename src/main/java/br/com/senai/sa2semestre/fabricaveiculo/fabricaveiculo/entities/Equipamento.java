package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/**
 * Entidade que representa um equipamento.
 */
@Entity
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipamento;
    private String tipoEquipamento;
    private String descricao;
    private String estado;

    @OneToMany(mappedBy = "equipamento")
    @JsonIgnore
    private List<Manutencao> listaDeManutencao;

    /**
     * Construtor padrão.
     */
    public Equipamento() {
    }

    /**
     * Construtor com parâmetros.
     *
     * @param idEquipamento O ID do equipamento
     * @param tipoEquipamento O tipo de equipamento
     * @param descricao A descrição do equipamento
     * @param estado O estado do equipamento
     * @param listaDeManutencao A lista de manutenções associadas ao equipamento
     */
    public Equipamento(Long idEquipamento, String tipoEquipamento, String descricao, String estado, List<Manutencao> listaDeManutencao) {
        this.idEquipamento = idEquipamento;
        this.tipoEquipamento = tipoEquipamento;
        this.descricao = descricao;
        this.estado = estado;
        this.listaDeManutencao = listaDeManutencao;
    }

    /**
     * Obtém o ID do equipamento.
     *
     * @return o ID do equipamento
     */
    public Long getIdEquipamento() {
        return idEquipamento;
    }

    /**
     * Define o ID do equipamento.
     *
     * @param idEquipamento o ID do equipamento
     */
    public void setIdEquipamento(Long idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    /**
     * Obtém o tipo de equipamento.
     *
     * @return o tipo de equipamento
     */
    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    /**
     * Define o tipo de equipamento.
     *
     * @param tipoEquipamento o tipo de equipamento
     */
    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    /**
     * Obtém a descrição do equipamento.
     *
     * @return a descrição do equipamento
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do equipamento.
     *
     * @param descricao a descrição do equipamento
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém o estado do equipamento.
     *
     * @return o estado do equipamento
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define o estado do equipamento.
     *
     * @param estado o estado do equipamento
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtém a lista de manutenções associadas ao equipamento.
     *
     * @return a lista de manutenções associadas ao equipamento
     */
    public List<Manutencao> getListaDeManutencao() {
        return listaDeManutencao;
    }

    /**
     * Define a lista de manutenções associadas ao equipamento.
     *
     * @param listaDeManutencao a lista de manutenções associadas ao equipamento
     */
    public void setListaDeManutencao(List<Manutencao> listaDeManutencao) {
        this.listaDeManutencao = listaDeManutencao;
    }

    /**
     * Compara este objeto com outro objeto para igualdade.
     *
     * @param o o objeto a ser comparado
     * @return true se os objetos são iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipamento that = (Equipamento) o;
        return Objects.equals(idEquipamento, that.idEquipamento) &&
                Objects.equals(tipoEquipamento, that.tipoEquipamento) &&
                Objects.equals(descricao, that.descricao) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(listaDeManutencao, that.listaDeManutencao);
    }

    /**
     * Retorna o valor de hash deste objeto.
     *
     * @return o valor de hash deste objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(idEquipamento, tipoEquipamento, descricao, estado, listaDeManutencao);
    }

    /**
     * Retorna a representação em string deste objeto.
     *
     * @return a representação em string deste objeto
     */
    @Override
    public String toString() {
        return "Equipamento{" +
                "idEquipamento=" + idEquipamento +
                ", tipoEquipamento='" + tipoEquipamento + '\'' +
                ", descricao='" + descricao + '\'' +
                ", estado='" + estado + '\'' +
                ", listaDeManutencao=" + listaDeManutencao +
                '}';
    }
}
