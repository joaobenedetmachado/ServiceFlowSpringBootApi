package com.example.serviceflow.controller;

import com.example.serviceflow.model.Pedidos;
import com.example.serviceflow.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping
    public ResponseEntity<List<Pedidos>> getPedidos() {
        List<Pedidos> pedidos = pedidosService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedidos> salvarPedido(@RequestBody Pedidos pedidos) {
        Pedidos pedidosSalvo = pedidosService.criarPedido(pedidos);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidosSalvo);
    }
}
