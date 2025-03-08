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

@RequestMapping("/servicos")
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<Servico> listarServico() {
        return servicoService.listarServicos();
    }

    @GetMapping("/buscar/{email}")
    public ResponseEntity<Map<String, List<Servico>>> buscarServico(@PathVariable String email) {
        List<Servico> servicos = servicoService.buscarServicoPorEmailEmpresa(email);
        Map<String, List<Servico>> response = new HashMap<>();
        response.put("servicos", servicos);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cadastrar/{email}")
    public ResponseEntity<Map<String, String>> cadastrarServico(
            @PathVariable String email,
            @RequestBody Servico servico) {
        servicoService.cadastrarServico(email, servico);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Serviço cadastrado com sucesso!");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/alterar/{email}")
    public ResponseEntity<Map<String, String>> alterarServico(
            @PathVariable String email,
            @RequestBody Map<String, String> dados) {
        servicoService.alterarServico(email, dados);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Serviço alterado com sucesso!");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/excluir/{email}")
    public ResponseEntity<Map<String, String>> excluirServico(
            @PathVariable String email,
            @RequestBody Map<String, String> dados) {
        servicoService.excluirServico(email, dados);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Serviço excluído com sucesso!");
        return ResponseEntity.ok(response);
    }
}
