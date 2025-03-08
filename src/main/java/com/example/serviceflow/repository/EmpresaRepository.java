package com.example.serviceflow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.serviceflow.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    Optional<Empresa> findByEmailempresa(String email);
    Optional<Empresa> findByEmailempresaAndSenhaempresa(String email, String senha);
    List<Empresa> findByNomeempresaStartingWithIgnoreCase(String nome);
}
