package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.empresa;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.EmpresaJpaEntity;

public interface EmpresaRepository extends PagingAndSortingRepository<EmpresaJpaEntity, Long> {

	Optional<EmpresaJpaEntity> findByPessoaJpaEntityId (long id);

}
