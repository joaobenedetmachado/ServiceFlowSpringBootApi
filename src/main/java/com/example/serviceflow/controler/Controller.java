package com.example.serviceflow.controler;

import com.example.serviceflow.modelos.Usuarios;
import com.example.serviceflow.servicos.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class Controller {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Usuarios>> buscarPorNome(@PathVariable String nome) {
        List<Usuarios> usuarios = usuarioService.encontrarUsuariosPorNome(nome);
        return ResponseEntity.ok(usuarios);
    }
}