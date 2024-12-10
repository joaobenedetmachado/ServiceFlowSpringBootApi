package com.example.serviceflow.servicos;

import com.example.serviceflow.modelos.Usuarios;
import com.example.serviceflow.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuarios> encontrarUsuariosPorNome(String nome) {
        return usuarioRepository.buscarPorNome(nome);
    }
}