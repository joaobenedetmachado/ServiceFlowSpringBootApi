package com.example.serviceflow.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name="pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // isso quer dizer que o id sera gerado pelo banco
    private Integer id;

    @Column(name="id_usuario")
    private Integer idUsuario;

    @Column(name="id_servico")
    private Integer idServico;

    @Column(name="data_pedido")
    private Date dataPedido;

    @Column(name="status")
    private String status;

    @Column(name="data_agendamento")
    private Date dataAgendamento;

    @Column(name="horario_agendamento")
    private Date horarioAgendamento;

    @Column(name="nome_cliente")
    private String nomeCliente;

    @Column(name="email_cliente")
    private String emailCliente;

    @Column(name="telefone_cliente", length=20) // Ajuste o tamanho conforme necessário
    private String telefoneCliente;

    @Column(name="id_empresa")
    private Integer idEmpresa;

    public Pedidos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Date getHorarioAgendamento() {
        return horarioAgendamento;
    }

    public void setHorarioAgendamento(Date horarioAgendamento) {
        this.horarioAgendamento = horarioAgendamento;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Pedidos(Integer id, Integer idUsuario, Integer idServico, Date dataPedido, String status, Date dataAgendamento, Date horarioAgendamento, String nomeCliente, String emailCliente, String telefoneCliente, Integer idEmpresa) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idServico = idServico;
        this.dataPedido = dataPedido;
        this.status = status;
        this.dataAgendamento = dataAgendamento;
        this.horarioAgendamento = horarioAgendamento;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
        this.idEmpresa = idEmpresa;
    }
}
