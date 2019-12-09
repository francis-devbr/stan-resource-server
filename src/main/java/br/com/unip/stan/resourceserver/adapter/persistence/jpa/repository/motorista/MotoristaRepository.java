package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.motorista;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

	List<Motorista> findByFuncionarioEmpresaCpfOuCnpj(String cnpj);
	
	Optional<Motorista> findByIdAndFuncionarioEmpresaCpfOuCnpj(Long id, String cnpj);
		
}
