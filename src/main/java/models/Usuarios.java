package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;
    private String nome;
    private String email;
    private String senha;
    private String perfi;


    public Usuarios() {
    }
    public Usuarios(long idUsuario, String nome, String email, String senha, String perfi) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfi = perfi;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfi() {
        return perfi;
    }

    public void setPerfi(String perfi) {
        this.perfi = perfi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuarios usuarios = (Usuarios) o;

        if (idUsuario != usuarios.idUsuario) return false;
        if (!Objects.equals(nome, usuarios.nome)) return false;
        if (!Objects.equals(email, usuarios.email)) return false;
        if (!Objects.equals(senha, usuarios.senha)) return false;
        return Objects.equals(perfi, usuarios.perfi);
    }

    @Override
    public int hashCode() {
        int result = (int) (idUsuario ^ (idUsuario >>> 32));
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        result = 31 * result + (perfi != null ? perfi.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", perfi='" + perfi + '\'' +
                '}';
    }
}
