package guincho_24h.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "solicitacao_guincho")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoGuincho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Placa do veículo é obrigatória")
    @Pattern(regexp = "^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$",
            message = "Placa deve estar no formato brasileiro (ex: ABC1234 ou ABC1D23)")
    @Column(name = "placa_veiculo", nullable = false, length = 8)
    private String placaVeiculo;

    @NotBlank(message = "Nome do cliente é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    @Column(name = "nome_cliente", nullable = false, length = 100)
    private String nomeCliente;

    @NotBlank(message = "Telefone celular é obrigatório")
    @Pattern(regexp = "^\\([1-9]{2}\\)\\s9?[0-9]{4}-[0-9]{4}$",
            message = "Telefone deve estar no formato (XX) 9XXXX-XXXX ou (XX) XXXX-XXXX")
    @Column(name = "fone_celular", nullable = false, length = 15)
    private String foneCelular;

    @NotBlank(message = "Endereço é obrigatório")
    @Size(min = 5, max = 200, message = "Endereço deve ter entre 5 e 200 caracteres")
    @Column(name = "endereco", nullable = false, length = 200)
    private String endereco;

    @NotBlank(message = "Cidade é obrigatória")
    @Size(min = 2, max = 100, message = "Cidade deve ter entre 2 e 100 caracteres")
    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;
}
