package com.example.serviceflow.repository;

import com.example.serviceflow.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
    List<Servico> findByIdEmpresa(Integer idEmpresa);
    
    Optional<Servico> findByTituloAndDescricaoAndIdEmpresa(
        String titulo, 
        String descricao, 
        Integer idEmpresa
    );
    
    void deleteByTituloAndDescricaoAndIdEmpresa(
        String titulo, 
        String descricao, 
        Integer idEmpresa
    );
}
