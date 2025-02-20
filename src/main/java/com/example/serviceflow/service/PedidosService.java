package com.example.serviceflow.service;

import com.example.serviceflow.model.Pedidos;
import com.example.serviceflow.repository.PedidosInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService {

    private PedidosInterface pedidosInterface;

    public List<Pedidos> listarPedidos() {
        return pedidosInterface.findAll();
    }

    public Pedidos criarPedido(Pedidos pedidos) {
        return pedidosInterface.save(pedidos);
    }
}
