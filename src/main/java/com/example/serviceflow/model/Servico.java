package com.example.serviceflow.model;

import jakarta.persistence.*;

@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // isso quer dizer que o id sera gerado pelo banco
    private Integer id;

    @Column(name="id_empresa")
    private Integer idEmpresa;

    @Column(name="titulo")
    private String titulo;

    @Column(name="descricao")
    private String descricao;

    @Column(name="preco")
    private double preco;

    @Column(name="contador_carrinho")
    private Integer contadorCarrinho;

    @Column(name="contador_vendas")
    private Integer contadorVendas;

    public Servico() {}

    public Servico(Integer id, Integer idEmpresa, String titulo, String descricao, double preco, Integer contadorCarrinho, Integer contadorVendas) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.contadorCarrinho = contadorCarrinho;
        this.contadorVendas = contadorVendas;
    }

    @Override
    public String toString() {
        return "Servicos{" +
                "id=" + id +
                ", idEmpresa=" + idEmpresa +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", contadorCarrinho=" + contadorCarrinho +
                ", contadorVendas=" + contadorVendas +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getContadorCarrinho() {
        return contadorCarrinho;
    }

    public void setContadorCarrinho(Integer contadorCarrinho) {
        this.contadorCarrinho = contadorCarrinho;
    }

    public Integer getContadorVendas() {
        return contadorVendas;
    }

    public void setContadorVendas(Integer contadorVendas) {
        this.contadorVendas = contadorVendas;
    }
}
