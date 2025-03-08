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

    @Column(name="orcamento")
    private Boolean orcamento;

    @Column(name="stripe_account_id")
    private String stripe_account_id;

    public Empresa() {};

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

    public Boolean getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Boolean orcamento) {
        this.orcamento = orcamento;
    }

    public String getStripe_account_id() {
        return stripe_account_id;
    }

    public void setStripe_account_id(String stripe_account_id) {
        this.stripe_account_id = stripe_account_id;
    }

    public Empresa(Integer id, String nomeempresa, String emailempresa, String senhaempresa, String descricaoempresa, Boolean orcamento, String stripe_account_id) {
        this.id = id;
        this.nomeempresa = nomeempresa;
        this.emailempresa = emailempresa;
        this.senhaempresa = senhaempresa;
        this.descricaoempresa = descricaoempresa;
        this.orcamento = orcamento;
        this.stripe_account_id = stripe_account_id;
    }
}
