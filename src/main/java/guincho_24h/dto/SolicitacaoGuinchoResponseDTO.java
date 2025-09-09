package guincho_24h.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoGuinchoResponseDTO {

    private Long id;
    private String placaVeiculo;
    private String nomeCliente;
    private String foneCelular;
    private String endereco;
    private String cidade;
}
