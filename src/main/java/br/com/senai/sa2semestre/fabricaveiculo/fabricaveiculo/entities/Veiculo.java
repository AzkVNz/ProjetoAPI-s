package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    /**
     * O número do chassi do veículo. Identificador único.
     */
    @Id
    private String chassi;

    /**
     * O modelo do veículo.
     */
    private String modelo;

    /**
     * O ano de fabricação do veículo.
     */
    private Long ano;

    /**
     * A cor do veículo.
     */
    private String cor;

    /**
     * A lista de peças associadas ao veículo.
     * Relacionamento muitos-para-muitos com a entidade Pecas.
     */
    @ManyToMany
    @JoinTable(
            name = "veiculos_pecas",
            joinColumns = {@JoinColumn(name = "chassi")},
            inverseJoinColumns = {@JoinColumn(name = "idPecas")}
    )
    private List<Pecas> pecas = new ArrayList<>();

    /**
     * Construtor padrão.
     */
    public Veiculo() {
    }

    /**
     * Construtor com parâmetros.
     *
     * @param chassi O número do chassi do veículo.
     * @param modelo O modelo do veículo.
     * @param ano O ano de fabricação do veículo.
     * @param cor A cor do veículo.
     * @param pecas A lista de peças associadas ao veículo.
     */
    public Veiculo(String chassi, String modelo, Long ano, String cor, List<Pecas> pecas) {
        this.chassi = chassi;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.pecas = pecas;
    }

    /**
     * Obtém o número do chassi do veículo.
     *
     * @return O número do chassi.
     */
    public String getChassi() {
        return chassi;
    }

    /**
     * Define o número do chassi do veículo.
     *
     * @param chassi O novo número do chassi.
     */
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    /**
     * Obtém o modelo do veículo.
     *
     * @return O modelo do veículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Define o modelo do veículo.
     *
     * @param modelo O novo modelo do veículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtém o ano de fabricação do veículo.
     *
     * @return O ano de fabricação do veículo.
     */
    public Long getAno() {
        return ano;
    }

    /**
     * Define o ano de fabricação do veículo.
     *
     * @param ano O novo ano de fabricação do veículo.
     */
    public void setAno(Long ano) {
        this.ano = ano;
    }

    /**
     * Obtém a cor do veículo.
     *
     * @return A cor do veículo.
     */
    public String getCor() {
        return cor;
    }

    /**
     * Define a cor do veículo.
     *
     * @param cor A nova cor do veículo.
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Obtém a lista de peças associadas ao veículo.
     *
     * @return A lista de peças.
     */
    public List<Pecas> getPecas() {
        return pecas;
    }

    /**
     * Define a lista de peças associadas ao veículo.
     *
     * @param pecas A nova lista de peças.
     */
    public void setPecas(List<Pecas> pecas) {
        this.pecas = pecas;
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

        Veiculo veiculo = (Veiculo) o;

        if (!chassi.equals(veiculo.chassi)) return false;
        if (!Objects.equals(modelo, veiculo.modelo)) return false;
        if (!Objects.equals(ano, veiculo.ano)) return false;
        if (!Objects.equals(cor, veiculo.cor)) return false;
        return Objects.equals(pecas, veiculo.pecas);
    }

    /**
     * Calcula o código hash para o objeto.
     *
     * @return O código hash calculado.
     */
    @Override
    public int hashCode() {
        int result = chassi.hashCode();
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        result = 31 * result + (ano != null ? ano.hashCode() : 0);
        result = 31 * result + (cor != null ? cor.hashCode() : 0);
        result = 31 * result + (pecas != null ? pecas.hashCode() : 0);
        return result;
    }

    /**
     * Retorna a representação em string do objeto.
     *
     * @return A representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Veiculo{" +
                "chassi='" + chassi + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                ", pecas=" + pecas +
                '}';
    }
}
