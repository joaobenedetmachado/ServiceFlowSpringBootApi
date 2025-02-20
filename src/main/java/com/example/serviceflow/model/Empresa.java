package com.example.serviceflow.model;

import jakarta.persistence.*;

@Entity
@Table(name="empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // isso quer dizer que o id sera gerado pelo banco
    private Integer id;

    @Column(name="nomeempresa")
    private String nomeempresa;

    @Column(name="emailempresa")
    private String emailempresa;

    @Column(name="senhaempresa")
    private String senhaempresa;

    @Column(name="descricaoempresa")
    private String descricaoempresa;

    @Column(name="stripe_account_id")
    private String stripe_account_id;

    public Empresa() {};

    public Empresa(Integer id, String nomeempresa, String emailempresa, String senhaempresa, String descricaoempresa, String stripe_account_id) {
        this.id = id;
        this.nomeempresa = nomeempresa;
        this.emailempresa = emailempresa;
        this.senhaempresa = senhaempresa;
        this.descricaoempresa = descricaoempresa;
        this.stripe_account_id = stripe_account_id;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nomeempresa='" + nomeempresa + '\'' +
                ", emailempresa='" + emailempresa + '\'' +
                ", senhaempresa='" + senhaempresa + '\'' +
                ", descricaoempresa='" + descricaoempresa + '\'' +
                ", stripe_account_id='" + stripe_account_id + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeempresa() {
        return nomeempresa;
    }

    public void setNomeempresa(String nomeempresa) {
        this.nomeempresa = nomeempresa;
    }

    public String getEmailempresa() {
        return emailempresa;
    }

    public void setEmailempresa(String emailempresa) {
        this.emailempresa = emailempresa;
    }

    public String getSenhaempresa() {
        return senhaempresa;
    }

    public void setSenhaempresa(String senhaempresa) {
        this.senhaempresa = senhaempresa;
    }

    public String getDescricaoempresa() {
        return descricaoempresa;
    }

    public void setDescricaoempresa(String descricaoempresa) {
        this.descricaoempresa = descricaoempresa;
    }

    public String getStripe_account_id() {
        return stripe_account_id;
    }

    public void setStripe_account_id(String stripe_account_id) {
        this.stripe_account_id = stripe_account_id;
    }
}
