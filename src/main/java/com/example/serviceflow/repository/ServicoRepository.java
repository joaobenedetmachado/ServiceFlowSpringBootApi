package com.example.serviceflow.repository;

import com.example.serviceflow.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
    List<Servico> findByIdEmpresa(Integer idEmpresa);
    
    Optional<Servico> findByTituloAndDescricaoAndIdEmpresa(
        String titulo, 
        String descricao, 
        Integer idEmpresa
    );

}
