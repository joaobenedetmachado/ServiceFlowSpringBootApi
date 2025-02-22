package com.example.serviceflow.service;

import com.example.serviceflow.model.Empresa;
import com.example.serviceflow.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Optional<Empresa> EmpresaPorID(Integer id) {
        return empresaRepository.findById(id);
    }

    public List<Empresa> listarTodasEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa salvarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
}
