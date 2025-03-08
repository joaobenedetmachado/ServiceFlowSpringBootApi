package com.example.serviceflow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.serviceflow.model.Usuario;
import com.example.serviceflow.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> loginUsuario(String email, String senha) {
        return usuarioRepository.findByEmailusuarioAndSenhausuario(email, senha);
    }

    public Optional<Usuario> encontrarPorID(Integer id) {
        return usuarioRepository.findById(id);
    }
}