package com.example.serviceflow.service;

import com.example.serviceflow.model.Empresa;
import com.example.serviceflow.model.Servico;
import com.example.serviceflow.repository.ServicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Map;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;
    
    @Autowired
    private EmpresaService empresaService;

    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }

    public Servico salvarServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public List<Servico> buscarServicoPorEmailEmpresa(String email) {
        Optional<Empresa> empresa = empresaService.buscarPorEmail(email);
        if (!empresa.isPresent()) {
            throw new RuntimeException("Empresa não encontrada");
        }
        return servicoRepository.findByIdEmpresa(empresa.get().getId());
    }

    public Servico cadastrarServico(String email, Servico servico) {
        Optional<Empresa> empresa = empresaService.buscarPorEmail(email);
        if (!empresa.isPresent()) {
            throw new RuntimeException("Empresa não encontrada");
        }
        servico.setIdEmpresa(empresa.get().getId());
        servico.setContadorCarrinho(0);
        servico.setContadorVendas(0);
        return servicoRepository.save(servico);
    }

    public void alterarServico(String email, Map<String, String> dados) {
        Optional<Empresa> empresa = empresaService.buscarPorEmail(email);
        if (!empresa.isPresent()) {
            throw new RuntimeException("Empresa não encontrada");
        }

        Servico servico = servicoRepository.findByTituloAndDescricaoAndIdEmpresa(
            dados.get("titulo_original"),
            dados.get("descricao_original"),
            empresa.get().getId()
        ).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        servico.setTitulo(dados.get("tituloservico"));
        servico.setDescricao(dados.get("descricaoservico"));
        servico.setPreco(Double.parseDouble(dados.get("preco")));
        
        servicoRepository.save(servico);
    }

}
