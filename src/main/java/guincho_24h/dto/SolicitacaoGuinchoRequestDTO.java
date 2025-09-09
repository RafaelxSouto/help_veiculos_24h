package guincho_24h.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoGuinchoRequestDTO {

    @NotBlank(message = "Placa do veículo é obrigatória")
    @Pattern(regexp = "^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$",
            message = "Placa deve estar no formato brasileiro (ex: ABC1234 ou ABC1D23)")
    private String placaVeiculo;

    @NotBlank(message = "Nome do cliente é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nomeCliente;

    @NotBlank(message = "Telefone celular é obrigatório")
    @Pattern(regexp = "^\\([1-9]{2}\\)\\s9?[0-9]{4}-[0-9]{4}$",
            message = "Telefone deve estar no formato (XX) 9XXXX-XXXX ou (XX) XXXX-XXXX")
    private String foneCelular;

    @NotBlank(message = "Endereço é obrigatório")
    @Size(min = 5, max = 200, message = "Endereço deve ter entre 5 e 200 caracteres")
    private String endereco;

    @NotBlank(message = "Cidade é obrigatória")
    @Size(min = 2, max = 100, message = "Cidade deve ter entre 2 e 100 caracteres")
    private String cidade;
}
