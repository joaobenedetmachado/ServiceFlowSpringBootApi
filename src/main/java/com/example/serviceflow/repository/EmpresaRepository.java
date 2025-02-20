package com.example.serviceflow.repository;

import com.example.serviceflow.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
