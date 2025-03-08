package com.example.serviceflow.repository;

import com.example.serviceflow.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmailusuarioAndSenhausuario(String email, String senha);
}
