package com.example.serviceflow.controller;

import com.example.serviceflow.model.Servico;
import com.example.serviceflow.model.Usuario;
import com.example.serviceflow.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping("/cadastrar/servico/{email}")
    public ResponseEntity<Servico> cadastrarServico(
            @PathVariable("email") String email,
            @RequestBody Servico servico) {
        System.out.println("Serviço recebido: " + servico);

        Servico novoServico = servicoService.cadastrarServico(email, servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServico);
    }


    @GetMapping("/buscar/servico/{email}")
    public List<Servico> buscarServicoPorEmailEmpresa(@PathVariable("email") String email){
        return servicoService.buscarServicoPorEmailEmpresa(email);
    }



}
