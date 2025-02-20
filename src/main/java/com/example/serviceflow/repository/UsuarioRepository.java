package com.example.serviceflow.repository;

import com.example.serviceflow.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
