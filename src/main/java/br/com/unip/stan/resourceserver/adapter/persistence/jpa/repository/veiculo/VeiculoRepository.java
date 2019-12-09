package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	Optional<Veiculo> findByIdAndEmpresaCpfOuCnpj(Long id, String cnpj);
	
}
