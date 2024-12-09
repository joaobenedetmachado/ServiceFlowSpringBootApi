package com.example.serviceflow.modelos;

public class Servicos {
    public String tituloServico;
    public String descricaoServico;
    public float precoServico;

    public Servicos(String tituloServico, String descricaoServico, float precoServico) {
        this.tituloServico = tituloServico;
        this.descricaoServico = descricaoServico;
        this.precoServico = precoServico;
    }

    public String getTituloServico() {
        return tituloServico;
    }

    public void setTituloServico(String tituloServico) {
        this.tituloServico = tituloServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public float getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(float precoServico) {
        this.precoServico = precoServico;
    }
}
