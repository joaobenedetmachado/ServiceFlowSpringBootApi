package com.example.serviceflow.controller;

import com.example.serviceflow.model.Usuario;
import com.example.serviceflow.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired // precisa disso pelo visto
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsers() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> encontrarPorId(@PathVariable("id") Integer id) {
        return usuarioService.encontrarPorID(id);
    }


    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
        Usuario userSalvo = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSalvo);
    }
}
