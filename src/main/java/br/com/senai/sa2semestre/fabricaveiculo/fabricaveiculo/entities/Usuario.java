package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 * Representa um usuário no sistema.
 * Esta entidade é mapeada para uma tabela do banco de dados usando anotações JPA.
 * Inclui detalhes como o ID do usuário, nome, email, senha e perfil.
 */
@Entity
public class Usuario {

    /**
     * Enumeração dos perfis de usuário.
     */
    public enum Perfil {
        ADMIN,
        USER,
        GUEST
    }

    /**
     * Identificador único do usuário.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    /**
     * Nome do usuário.
     */
    private String nome;

    /**
     * Email do usuário.
     */
    private String email;

    /**
     * Senha do usuário.
     */
    private String senha;

    /**
     * Perfil do usuário.
     */
    private Perfil perfil;

    /**
     * Construtor padrão.
     */
    public Usuario() {
    }

    /**
     * Construtor com parâmetros.
     *
     * @param idUsuario O identificador do usuário.
     * @param nome      O nome do usuário.
     * @param email     O email do usuário.
     * @param senha     A senha do usuário.
     * @param perfil    O perfil do usuário.
     */
    public Usuario(Long idUsuario, String nome, String email, String senha, Perfil perfil) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    /**
     * Obtém o identificador do usuário.
     *
     * @return O identificador do usuário.
     */
    public Long getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define o identificador do usuário.
     *
     * @param idUsuario O novo identificador do usuário.
     */
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtém o nome do usuário.
     *
     * @return O nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     *
     * @param nome O novo nome do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o email do usuário.
     *
     * @return O email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário.
     *
     * @param email O novo email do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return A senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha A nova senha do usuário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Obtém o perfil do usuário.
     *
     * @return O perfil do usuário.
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * Define o perfil do usuário.
     *
     * @param perfil O novo perfil do usuário.
     */
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
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

        Usuario usuario = (Usuario) o;

        if (!idUsuario.equals(usuario.idUsuario)) return false;
        if (!Objects.equals(nome, usuario.nome)) return false;
        if (!Objects.equals(email, usuario.email)) return false;
        if (!Objects.equals(senha, usuario.senha)) return false;
        return perfil == usuario.perfil;
    }

    /**
     * Calcula o código hash para o objeto.
     *
     * @return O código hash calculado.
     */
    @Override
    public int hashCode() {
        int result = idUsuario.hashCode();
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        result = 31 * result + (perfil != null ? perfil.hashCode() : 0);
        return result;
    }

    /**
     * Retorna a representação em string do objeto.
     *
     * @return A representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", perfil=" + perfil +
                '}';
    }
}
