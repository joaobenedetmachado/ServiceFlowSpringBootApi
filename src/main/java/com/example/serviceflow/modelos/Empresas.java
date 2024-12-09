package com.example.serviceflow.modelos;

public class Empresas {
    public String nomeEmpresa;
    public String emailEmpresa;
    public String senhaEmpresa;
    public String DescricaoEmpresa;

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getDescricaoEmpresa() {
        return DescricaoEmpresa;
    }

    public void setDescricaoEmpresa(String descricaoEmpresa) {
        DescricaoEmpresa = descricaoEmpresa;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public String getSenhaEmpresa() {
        return senhaEmpresa;
    }

    public void setSenhaEmpresa(String senhaEmpresa) {
        this.senhaEmpresa = senhaEmpresa;
    }

    public Empresas(String nomeEmpresa, String emailEmpresa, String senhaEmpresa, String descricaoEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.senhaEmpresa = senhaEmpresa;
        DescricaoEmpresa = descricaoEmpresa;


    }
}
