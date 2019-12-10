package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Abastecimento;

public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {

	List<Abastecimento> findByCnpj(String cnpj);

	Optional<Abastecimento> findByCnpjAndId(String cnpj, Long id);
	
}
