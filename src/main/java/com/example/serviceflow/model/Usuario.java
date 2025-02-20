package com.example.serviceflow.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // isso quer dizer que o id sera gerado pelo banco
    private Integer id;

    @Column(name = "nomeusuario")
    private String nomeusuario;

    @Column(name = "emailusuario", unique = true)
    private String emailusuario;

    @Column(name = "senhausuario")
    private String senhausuario;

    public Usuario() {}

    public Usuario(Integer id, String nomeusuario, String emailusuario, String senhausuario) {
        this.id = id;
        this.nomeusuario = nomeusuario;
        this.emailusuario = emailusuario;
        this.senhausuario = senhausuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nomeusuario='" + nomeusuario + '\'' +
                ", emailusuario='" + emailusuario + '\'' +
                ", senhausuario='" + senhausuario + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public String getEmailusuario() {
        return emailusuario;
    }

    public void setEmailusuario(String emailusuario) {
        this.emailusuario = emailusuario;
    }

    public String getSenhausuario() {
        return senhausuario;
    }

    public void setSenhausuario(String senhausuario) {
        this.senhausuario = senhausuario;
    }
}
