package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long iDManutencao;
    private long iDEquipamento;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String descricaoServico;
    private String estado;

    public Manutencao(long iDManutencao, long iDEquipamento, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String descricaoServico, String estado) {
        this.iDManutencao = iDManutencao;
        this.iDEquipamento = iDEquipamento;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.descricaoServico = descricaoServico;
        this.estado = estado;
    }

    public long getiDManutencao() {
        return iDManutencao;
    }

    public void setiDManutencao(long iD_Manutencao) {
        this.iDManutencao = iD_Manutencao;
    }

    public long getiDEquipamento() {
        return iDEquipamento;
    }

    public void setiDEquipamento(long iD_Equipamento) {
        this.iDEquipamento = iD_Equipamento;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manutencao that = (Manutencao) o;

        if (iDManutencao != that.iDManutencao) return false;
        if (iDEquipamento != that.iDEquipamento) return false;
        if (!Objects.equals(dataHoraInicio, that.dataHoraInicio))
            return false;
        if (!Objects.equals(dataHoraFim, that.dataHoraFim)) return false;
        if (!Objects.equals(descricaoServico, that.descricaoServico))
            return false;
        return Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        int result = (int) (iDManutencao ^ (iDManutencao >>> 32));
        result = 31 * result + (int) (iDEquipamento ^ (iDEquipamento >>> 32));
        result = 31 * result + (dataHoraInicio != null ? dataHoraInicio.hashCode() : 0);
        result = 31 * result + (dataHoraFim != null ? dataHoraFim.hashCode() : 0);
        result = 31 * result + (descricaoServico != null ? descricaoServico.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "manutencao{" +
                "iD_Manutencao=" + iDManutencao +
                ", iD_Equipamento=" + iDEquipamento +
                ", dataHoraInicio='" + dataHoraInicio + '\'' +
                ", dataHoraFim='" + dataHoraFim + '\'' +
                ", descricaoServico='" + descricaoServico + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
