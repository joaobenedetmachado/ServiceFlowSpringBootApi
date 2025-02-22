package com.example.serviceflow.controller;

import com.example.serviceflow.model.Empresa;
import com.example.serviceflow.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/{id}")
    public Optional<Empresa> BuscarPorId(@PathVariable("id") Integer id) {
        return empresaService.EmpresaPorID(id);
    }

    @GetMapping
    public List<Empresa> listarEmpresas() {
        return empresaService.listarTodasEmpresas();
    }

    @PostMapping
    public ResponseEntity<Empresa> salvarEmpresa(@RequestBody Empresa empresa) {
        Empresa empresasalva = empresaService.salvarEmpresa(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresasalva);
    }
}
