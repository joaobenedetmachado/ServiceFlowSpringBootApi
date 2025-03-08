package com.example.serviceflow.controller;

import com.example.serviceflow.model.Usuario;
import com.example.serviceflow.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Optional<Usuario>> encontrarPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(usuarioService.encontrarPorID(id));
    }

    @GetMapping("/cadastro/usuario")
    public ResponseEntity<Map<String, List<Usuario>>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        Map<String, List<Usuario>> response = new HashMap<>();
        response.put("usuarios", usuarios);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cadastro/usuario")
    public ResponseEntity<Map<String, Object>> salvarUsuario(@RequestBody Usuario usuario) {
        Usuario userSalvo = usuarioService.salvarUsuario(usuario);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Usuário cadastrado com sucesso!");
        response.put("id", userSalvo.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login/usuario")
    public ResponseEntity<Map<String, Object>> loginUsuario(
            @RequestParam String email,
            @RequestParam String senha) {

        Optional<Usuario> usuario = usuarioService.loginUsuario(email, senha);
        Map<String, Object> response = new HashMap<>();

        if (usuario.isPresent()) {
            response.put("message", "Login realizado com sucesso!");
            response.put("id", usuario.get().getId());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Email ou senha incorretos");
            return ResponseEntity.ok(response);
        }
    }
}