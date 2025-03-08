package com.example.serviceflow.service;

import com.example.serviceflow.model.Empresa;
import com.example.serviceflow.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> listarTodasEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa salvarEmpresa(Empresa empresa) {
        if (empresaRepository.findByEmailempresa(empresa.getEmailempresa()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }
        empresa.setDescricaoempresa("Empresa cadastrada via ServiceFlow");
        return empresaRepository.save(empresa);
    }

    public Optional<Empresa> loginEmpresa(String email, String senha) {
        return empresaRepository.findByEmailempresaAndSenhaempresa(email, senha);
    }

    public List<Map<String, Object>> buscarEmpresaPorNome(String nome) {
        List<Empresa> empresas = empresaRepository.findByNomeempresaStartingWithIgnoreCase(nome);
        return empresas.stream()
            .map(empresa -> {
                Map<String, Object> map = new HashMap<>();
                map.put("id", empresa.getId());
                map.put("nomeempresa", empresa.getNomeempresa());
                map.put("emailempresa", empresa.getEmailempresa());
                map.put("descricaoempresa", empresa.getDescricaoempresa());
                return map;
            })
            .collect(Collectors.toList());
    }

    public Map<String, Object> buscarEmpresaInfos(String email) {
        Empresa empresa = empresaRepository.findByEmailempresa(email)
            .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        Map<String, Object> response = new HashMap<>();
        response.put("id", empresa.getId());
        response.put("nomeempresa", empresa.getNomeempresa());
        response.put("emailempresa", empresa.getEmailempresa());
        response.put("descricaoempresa", empresa.getDescricaoempresa());
        response.put("orcamento", empresa.getOrcamento());
        response.put("stripe_account_id", 
            empresa.getStripe_account_id() == null ? false : empresa.getStripe_account_id());

        return response;
    }

    public void alterarEmpresa(String email, Map<String, String> dados) {
        Empresa empresa = empresaRepository.findByEmailempresa(email)
            .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        if (dados.containsKey("nomeempresa")) {
            empresa.setNomeempresa(dados.get("nomeempresa"));
        }
        if (dados.containsKey("descricaoempresa")) {
            empresa.setDescricaoempresa(dados.get("descricaoempresa"));
        }

        empresaRepository.save(empresa);
    }

    public Optional<Empresa> buscarPorEmail(String email) {
        return empresaRepository.findByEmailempresa(email);
    }
}
