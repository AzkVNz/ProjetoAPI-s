package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Producao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducao;
    @ManyToOne
    @JoinColumn(name = "idPecas", referencedColumnName = "idPecas")
    private Pecas pecas;
    private LocalDateTime dataHora;
    private Long quantidadeProduzida;
    private String estado;

    @OneToMany(mappedBy = "qualiade")
    private List<Qualidade> listaDeQualidade;

    public Producao() {
    }

    public Long getIdProducao() {
        return idProducao;
    }

    public void setIdProducao(Long idProducao) {
        this.idProducao = idProducao;
    }

    public Pecas getPecas() {
        return pecas;
    }

    public void setPecas(Pecas pecas) {
        this.pecas = pecas;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Long getQuantidadeProduzida() {
        return quantidadeProduzida;
    }

    public void setQuantidadeProduzida(Long quantidadeProduzida) {
        this.quantidadeProduzida = quantidadeProduzida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Qualidade> getListaDeQualidade() {
        return listaDeQualidade;
    }

    public void setListaDeQualidade(List<Qualidade> listaDeQualidade) {
        this.listaDeQualidade = listaDeQualidade;
    }

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
