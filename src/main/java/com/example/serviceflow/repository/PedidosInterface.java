package com.example.serviceflow.repository;

import com.example.serviceflow.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosInterface extends JpaRepository<Pedidos, Integer> {
}
