package com.example.serviceflow.controller;

import com.example.serviceflow.model.Servico;
import com.example.serviceflow.model.Usuario;
import com.example.serviceflow.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/servicos")
@RestController
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<Servico> listarServico() {
        return servicoService.listarServicos();
    }

    @PostMapping
    public ResponseEntity<Servico> salvarServico(@RequestBody Servico servico) {
        Servico servicosalvo = servicoService.salvarServico(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicosalvo);
    }
}
