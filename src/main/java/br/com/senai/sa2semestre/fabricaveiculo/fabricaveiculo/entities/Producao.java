package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Representa uma produção no sistema de fabricação de veículos.
 * Esta entidade é mapeada para uma tabela do banco de dados usando anotações JPA.
 * Inclui detalhes como o ID da produção, as peças associadas, data e hora da produção,
 * quantidade produzida, estado da produção e a lista de inspeções de qualidade associadas.
 */
@Entity
public class Producao {

    /**
     * Identificador único da produção.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducao;

    /**
     * Peças associadas a esta produção.
     */
    @ManyToOne
    @JoinColumn(name = "idPecas", referencedColumnName = "idPecas")
    private Pecas pecas;

    /**
     * Data e hora da produção.
     */
    private LocalDateTime dataHora;

    /**
     * Quantidade produzida.
     */
    private Long quantidadeProduzida;

    /**
     * Estado da produção.
     */
    private String estado;

    /**
     * Lista de inspeções de qualidade associadas a esta produção.
     */
    @OneToMany(mappedBy = "producao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Qualidade> listaDeQualidade;

    /**
     * Construtor padrão.
     */
    public Producao() {
    }

    /**
     * Construtor com parâmetros.
     *
     * @param idProducao O identificador da produção.
     * @param pecas As peças associadas.
     * @param dataHora  A data e hora da produção.
     * @param quantidadeProduzida A quantidade produzida.
     * @param estado O estado da produção.
     * @param listaDeQualidade A lista de inspeções de qualidade associadas.
     */
    public Producao(Long idProducao, Pecas pecas, LocalDateTime dataHora, Long quantidadeProduzida, String estado, List<Qualidade> listaDeQualidade) {
        this.idProducao = idProducao;
        this.pecas = pecas;
        this.dataHora = dataHora;
        this.quantidadeProduzida = quantidadeProduzida;
        this.estado = estado;
        this.listaDeQualidade = listaDeQualidade;
    }

    /**
     * Obtém o identificador da produção.
     *
     * @return O identificador da produção.
     */
    public Long getIdProducao() {
        return idProducao;
    }

    /**
     * Define o identificador da produção.
     *
     * @param idProducao O novo identificador da produção.
     */
    public void setIdProducao(Long idProducao) {
        this.idProducao = idProducao;
    }

    /**
     * Obtém as peças associadas a esta produção.
     *
     * @return As peças associadas.
     */
    public Pecas getPecas() {
        return pecas;
    }

    /**
     * Define as peças associadas a esta produção.
     *
     * @param pecas As novas peças associadas.
     */
    public void setPecas(Pecas pecas) {
        this.pecas = pecas;
    }

    /**
     * Obtém a data e hora da produção.
     *
     * @return A data e hora da produção.
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    /**
     * Define a data e hora da produção.
     *
     * @param dataHora A nova data e hora da produção.
     */
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Obtém a quantidade produzida.
     *
     * @return A quantidade produzida.
     */
    public Long getQuantidadeProduzida() {
        return quantidadeProduzida;
    }

    /**
     * Define a quantidade produzida.
     *
     * @param quantidadeProduzida A nova quantidade produzida.
     */
    public void setQuantidadeProduzida(Long quantidadeProduzida) {
        this.quantidadeProduzida = quantidadeProduzida;
    }

    /**
     * Obtém o estado da produção.
     *
     * @return O estado da produção.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define o estado da produção.
     *
     * @param estado O novo estado da produção.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtém a lista de inspeções de qualidade associadas a esta produção.
     *
     * @return A lista de inspeções de qualidade associadas.
     */
    public List<Qualidade> getListaDeQualidade() {
        return listaDeQualidade;
    }

    /**
     * Define a lista de inspeções de qualidade associadas a esta produção.
     *
     * @param listaDeQualidade A nova lista de inspeções de qualidade associadas.
     */
    public void setListaDeQualidade(List<Qualidade> listaDeQualidade) {
        this.listaDeQualidade = listaDeQualidade;
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

        Producao producao = (Producao) o;

        if (!idProducao.equals(producao.idProducao)) return false;
        if (!Objects.equals(pecas, producao.pecas)) return false;
        if (!Objects.equals(dataHora, producao.dataHora)) return false;
        if (!Objects.equals(quantidadeProduzida, producao.quantidadeProduzida))
            return false;
        if (!Objects.equals(estado, producao.estado)) return false;
        return Objects.equals(listaDeQualidade, producao.listaDeQualidade);
    }

    /**
     * Calcula o código hash para o objeto.
     *
     * @return O código hash calculado.
     */
    @Override
    public int hashCode() {
        int result = idProducao.hashCode();
        result = 31 * result + (pecas != null ? pecas.hashCode() : 0);
        result = 31 * result + (dataHora != null ? dataHora.hashCode() : 0);
        result = 31 * result + (quantidadeProduzida != null ? quantidadeProduzida.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (listaDeQualidade != null ? listaDeQualidade.hashCode() : 0);
        return result;
    }

    /**
     * Retorna a representação em string do objeto.
     *
     * @return A representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Producao{" +
                "idProducao=" + idProducao +
                ", pecas=" + pecas +
                ", dataHora=" + dataHora +
                ", quantidadeProduzida=" + quantidadeProduzida +
                ", estado='" + estado + '\'' +
                ", listaDeQualidade=" + listaDeQualidade +
                '}';
    }
}
