package guincho_24h.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import guincho_24h.entity.SolicitacaoGuincho;

@Repository
public interface SolicitacaoGuinchoRepository extends JpaRepository<SolicitacaoGuincho, Long> {

    @Query("SELECT s FROM SolicitacaoGuincho s WHERE s.placaVeiculo = :placaVeiculo")
    List<SolicitacaoGuincho> findByPlacaVeiculo(@Param("placaVeiculo") String placaVeiculo);

    @Query("SELECT s FROM SolicitacaoGuincho s WHERE UPPER(s.nomeCliente) LIKE UPPER(CONCAT('%', :nomeCliente, '%'))")
    List<SolicitacaoGuincho> findByNomeClienteContainingIgnoreCase(
            @Param("nomeCliente") String nomeCliente);
}
