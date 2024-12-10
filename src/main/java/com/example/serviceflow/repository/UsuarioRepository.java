package com.example.serviceflow.repositorios;

import com.example.serviceflow.modelos.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

    @Query(value = "SELECT * FROM usuarios WHERE nome_usuario = :nome", nativeQuery = true)
    List<Usuarios> buscarPorNome(@Param("nome") String nome);

    @Query(value = "SELECT * FROM usuarios WHERE email_usuario = :email", nativeQuery = true)
    Usuarios buscarPorEmail(@Param("email") String email);

}