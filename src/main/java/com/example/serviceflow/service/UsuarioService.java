package com.example.serviceflow.service;

import com.example.serviceflow.model.Usuario;
import com.example.serviceflow.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> encontrarPorID(Integer id) {
        return usuarioRepository.findById(id);
    }


    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
