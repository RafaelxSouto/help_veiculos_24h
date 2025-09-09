package guincho_24h.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import guincho_24h.dto.SolicitacaoGuinchoRequestDTO;
import guincho_24h.dto.SolicitacaoGuinchoResponseDTO;
import guincho_24h.entity.SolicitacaoGuincho;
import guincho_24h.repository.SolicitacaoGuinchoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SolicitacaoGuinchoService {

    private final SolicitacaoGuinchoRepository repository;

    public SolicitacaoGuinchoResponseDTO criarSolicitacao(SolicitacaoGuinchoRequestDTO request) {
        SolicitacaoGuincho solicitacao = new SolicitacaoGuincho();
        solicitacao.setPlacaVeiculo(request.getPlacaVeiculo().toUpperCase());
        solicitacao.setNomeCliente(request.getNomeCliente());
        solicitacao.setFoneCelular(request.getFoneCelular());
        solicitacao.setEndereco(request.getEndereco());
        solicitacao.setCidade(request.getCidade());

        SolicitacaoGuincho solicitacaoSalva = repository.save(solicitacao);

        return convertToResponseDTO(solicitacaoSalva);
    }

    public List<SolicitacaoGuinchoResponseDTO> buscarPorPlaca(String placa) {
        List<SolicitacaoGuincho> solicitacoes = repository.findByPlacaVeiculo(placa.toUpperCase());
        return solicitacoes.stream().map(this::convertToResponseDTO).collect(Collectors.toList());
    }

    public List<SolicitacaoGuinchoResponseDTO> buscarPorNomeCliente(String nomeCliente) {
        List<SolicitacaoGuincho> solicitacoes =
                repository.findByNomeClienteContainingIgnoreCase(nomeCliente);
        return solicitacoes.stream().map(this::convertToResponseDTO).collect(Collectors.toList());
    }

    private SolicitacaoGuinchoResponseDTO convertToResponseDTO(SolicitacaoGuincho solicitacao) {
        return new SolicitacaoGuinchoResponseDTO(solicitacao.getId(), solicitacao.getPlacaVeiculo(),
                solicitacao.getNomeCliente(), solicitacao.getFoneCelular(),
                solicitacao.getEndereco(), solicitacao.getCidade());
    }
}
