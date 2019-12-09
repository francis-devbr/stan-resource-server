package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.empresa;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Funcionario;

public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Long> {

	Optional<Funcionario> findByUsuarioId(Long usuarioId);
	
}
