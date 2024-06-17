package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Representa uma entidade de Manutenção para equipamentos.
 */
@Entity
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iDManutencao;

    @ManyToOne
    @JoinColumn(name = "idEquipamento", referencedColumnName = "idEquipamento")
    private Equipamento equipamento;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dataHoraInicio;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dataHoraFim;

    private String descricaoServico;
    private String estado;

    /**
     * Construtor padrão.
     */
    public Manutencao() {
    }

    /**
     * Construtor com parâmetros.
     *
     * @param iDManutencao O ID da manutenção.
     * @param equipamento O equipamento associado à manutenção.
     * @param dataHoraInicio A data e hora de início da manutenção.
     * @param dataHoraFim A data e hora de término da manutenção.
     * @param descricaoServico A descrição do serviço realizado na manutenção.
     * @param estado O estado atual da manutenção.
     */
    public Manutencao(Long iDManutencao, Equipamento equipamento, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String descricaoServico, String estado) {
        this.iDManutencao = iDManutencao;
        this.equipamento = equipamento;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.descricaoServico = descricaoServico;
        this.estado = estado;
    }

    /**
     * Obtém o ID da manutenção.
     *
     * @return o ID da manutenção.
     */
    public Long getiDManutencao() {
        return iDManutencao;
    }

    /**
     * Define o ID da manutenção.
     *
     * @param iDManutencao o ID da manutenção.
     */
    public void setiDManutencao(Long iDManutencao) {
        this.iDManutencao = iDManutencao;
    }

    /**
     * Obtém o equipamento associado à manutenção.
     *
     * @return o equipamento associado à manutenção.
     */
    public Equipamento getEquipamento() {
        return equipamento;
    }

    /**
     * Define o equipamento associado à manutenção.
     *
     * @param equipamento o equipamento associado à manutenção.
     */
    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    /**
     * Obtém a data e hora de início da manutenção.
     *
     * @return a data e hora de início da manutenção.
     */
    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    /**
     * Define a data e hora de início da manutenção.
     *
     * @param dataHoraInicio a data e hora de início da manutenção.
     */
    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    /**
     * Obtém a data e hora de término da manutenção.
     *
     * @return a data e hora de término da manutenção.
     */
    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    /**
     * Define a data e hora de término da manutenção.
     *
     * @param dataHoraFim a data e hora de término da manutenção.
     */
    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    /**
     * Obtém a descrição do serviço realizado na manutenção.
     *
     * @return a descrição do serviço realizado na manutenção.
     */
    public String getDescricaoServico() {
        return descricaoServico;
    }

    /**
     * Define a descrição do serviço realizado na manutenção.
     *
     * @param descricaoServico a descrição do serviço realizado na manutenção.
     */
    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    /**
     * Obtém o estado atual da manutenção.
     *
     * @return o estado atual da manutenção.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define o estado atual da manutenção.
     *
     * @param estado o estado atual da manutenção.
     */
    public void setEstado(String estado) {
        this.estado = estado;
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

        Manutencao that = (Manutencao) o;

        if (!iDManutencao.equals(that.iDManutencao)) return false;
        if (!Objects.equals(equipamento, that.equipamento)) return false;
        if (!Objects.equals(dataHoraInicio, that.dataHoraInicio))
            return false;
        if (!Objects.equals(dataHoraFim, that.dataHoraFim)) return false;
        if (!Objects.equals(descricaoServico, that.descricaoServico))
            return false;
        return Objects.equals(estado, that.estado);
    }

    /**
     * Retorna o valor de hash do objeto.
     *
     * @return o valor de hash do objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(iDManutencao, equipamento, dataHoraInicio, dataHoraFim, descricaoServico, estado);
    }

    /**
     * Retorna a representação em string do objeto.
     *
     * @return a representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Manutencao{" +
                "iDManutencao=" + iDManutencao +
                ", equipamento=" + equipamento +
                ", dataHoraInicio=" + dataHoraInicio +
                ", dataHoraFim=" + dataHoraFim +
                ", descricaoServico='" + descricaoServico + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
