package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Representa uma inspeção de qualidade no sistema de fabricação de veículos.
 * Esta entidade é mapeada para uma tabela do banco de dados usando anotações JPA.
 * Inclui detalhes como o ID da inspeção, a produção associada, data e hora da inspeção,
 * o resultado da inspeção e comentários adicionais.
 */
@Entity
public class Qualidade {

    /**
     * Identificador único da inspeção de qualidade.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInspecao;

    /**
     * Produção associada a esta inspeção de qualidade.
     */
    @ManyToOne
    @JoinColumn(name = "idProducao", referencedColumnName = "idProducao")
    private Producao producao;

    /**
     * Data e hora da inspeção de qualidade.
     */
    private LocalDateTime dataHora;

    /**
     * Resultado da inspeção de qualidade.
     */
    private String resultado;

    /**
     * Comentários adicionais sobre a inspeção de qualidade.
     */
    private String comentarios;

    /**
     * Construtor padrão.
     */
    public Qualidade() {
    }

    /**
     * Construtor com parâmetros.
     *
     * @param idInspecao O identificador da inspeção de qualidade.
     * @param producao A produção associada.
     * @param dataHora A data e hora da inspeção.
     * @param resultado O resultado da inspeção.
     * @param comentarios Os comentários adicionais.
     */
    public Qualidade(Long idInspecao, Producao producao, LocalDateTime dataHora, String resultado, String comentarios) {
        this.idInspecao = idInspecao;
        this.producao = producao;
        this.dataHora = dataHora;
        this.resultado = resultado;
        this.comentarios = comentarios;
    }

    /**
     * Obtém o identificador da inspeção de qualidade.
     *
     * @return O identificador da inspeção.
     */
    public Long getIdInspecao() {
        return idInspecao;
    }

    /**
     * Define o identificador da inspeção de qualidade.
     *
     * @param idInspecao O novo identificador da inspeção.
     */
    public void setIdInspecao(Long idInspecao) {
        this.idInspecao = idInspecao;
    }

    /**
     * Obtém a produção associada a esta inspeção de qualidade.
     *
     * @return A produção associada.
     */
    public Producao getProducao() {
        return producao;
    }

    /**
     * Define a produção associada a esta inspeção de qualidade.
     *
     * @param producao A nova produção associada.
     */
    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    /**
     * Obtém a data e hora da inspeção de qualidade.
     *
     * @return A data e hora da inspeção.
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    /**
     * Define a data e hora da inspeção de qualidade.
     *
     * @param dataHora A nova data e hora da inspeção.
     */
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Obtém o resultado da inspeção de qualidade.
     *
     * @return O resultado da inspeção.
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Define o resultado da inspeção de qualidade.
     *
     * @param resultado O novo resultado da inspeção.
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * Obtém os comentários adicionais sobre a inspeção de qualidade.
     *
     * @return Os comentários adicionais.
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * Define os comentários adicionais sobre a inspeção de qualidade.
     *
     * @param comentarios Os novos comentários adicionais.
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
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

        Qualidade qualidade = (Qualidade) o;

        if (!idInspecao.equals(qualidade.idInspecao)) return false;
        if (!Objects.equals(producao, qualidade.producao)) return false;
        if (!Objects.equals(dataHora, qualidade.dataHora)) return false;
        if (!Objects.equals(resultado, qualidade.resultado)) return false;
        return Objects.equals(comentarios, qualidade.comentarios);
    }

    /**
     * Calcula o código hash para o objeto.
     *
     * @return O código hash calculado.
     */
    @Override
    public int hashCode() {
        int result = idInspecao.hashCode();
        result = 31 * result + (producao != null ? producao.hashCode() : 0);
        result = 31 * result + (dataHora != null ? dataHora.hashCode() : 0);
        result = 31 * result + (resultado != null ? resultado.hashCode() : 0);
        result = 31 * result + (comentarios != null ? comentarios.hashCode() : 0);
        return result;
    }

    /**
     * Retorna a representação em string do objeto.
     *
     * @return A representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Qualidade{" +
                "idInspecao=" + idInspecao +
                ", producao=" + producao +
                ", dataHora=" + dataHora +
                ", resultado='" + resultado + '\'' +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}
