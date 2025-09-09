package guincho_24h.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import guincho_24h.dto.SolicitacaoGuinchoRequestDTO;
import guincho_24h.dto.SolicitacaoGuinchoResponseDTO;
import guincho_24h.service.SolicitacaoGuinchoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/guincho")
@RequiredArgsConstructor
public class SolicitacaoGuinchoController {

    private final SolicitacaoGuinchoService service;

    @PostMapping("/solicitar")
    public ResponseEntity<SolicitacaoGuinchoResponseDTO> solicitarGuincho(
            @Valid @RequestBody SolicitacaoGuinchoRequestDTO request) {
        SolicitacaoGuinchoResponseDTO response = service.criarSolicitacao(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/placa/{placa}")
    public ResponseEntity<List<SolicitacaoGuinchoResponseDTO>> buscarPorPlaca(
            @PathVariable String placa) {
        List<SolicitacaoGuinchoResponseDTO> solicitacoes = service.buscarPorPlaca(placa);

        if (solicitacoes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(solicitacoes, HttpStatus.OK);
    }

    @GetMapping("/buscar/cliente/{nomeCliente}")
    public ResponseEntity<List<SolicitacaoGuinchoResponseDTO>> buscarPorNomeCliente(
            @PathVariable String nomeCliente) {
        List<SolicitacaoGuinchoResponseDTO> solicitacoes =
                service.buscarPorNomeCliente(nomeCliente);

        if (solicitacoes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(solicitacoes, HttpStatus.OK);
    }
}
