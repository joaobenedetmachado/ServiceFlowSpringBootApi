package com.example.serviceflow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.serviceflow.model.Empresa;
import com.example.serviceflow.service.EmpresaService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/cadastro/empresa")
    public ResponseEntity<Map<String, List<Empresa>>> listarEmpresas() {
        List<Empresa> empresas = empresaService.listarTodasEmpresas();
        Map<String, List<Empresa>> response = new HashMap<>();
        response.put("empresas", empresas);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cadastro/empresa")
    public ResponseEntity<Map<String, Object>> cadastrarEmpresa(@RequestBody Empresa empresa) {
        Empresa empresaSalva = empresaService.salvarEmpresa(empresa);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Empresa cadastrada com sucesso!");
        response.put("id", empresaSalva.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login/empresa")
    public ResponseEntity<Map<String, Object>> loginEmpresa(
            @RequestParam String email,
            @RequestParam String senha) {
        Optional<Empresa> empresa = empresaService.loginEmpresa(email, senha);
        Map<String, Object> response = new HashMap<>();

        if (empresa.isPresent()) {
            response.put("message", "Login realizado com sucesso!");
            response.put("id", empresa.get().getId());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Email ou senha incorretos");
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/buscar/empresa/{value}")
    public ResponseEntity<Map<String, List<Map<String, Object>>>> buscarEmpresa(
            @PathVariable String value) {
        List<Map<String, Object>> empresas = empresaService.buscarEmpresaPorNome(value);
        Map<String, List<Map<String, Object>>> response = new HashMap<>();
        response.put("empresas", empresas);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar/empresa/infos/{email}")
    public ResponseEntity<Map<String, Object>> buscarEmpresaInfos(@PathVariable String email) {
        return ResponseEntity.ok(empresaService.buscarEmpresaInfos(email));
    }

    @PostMapping("/alterar/empresa/{email}")
    public ResponseEntity<Map<String, String>> alterarEmpresa(
            @PathVariable String email,
            @RequestBody Map<String, String> dados) {
        empresaService.alterarEmpresa(email, dados);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Dados alterados com sucesso!");
        return ResponseEntity.ok(response);
    }
}
