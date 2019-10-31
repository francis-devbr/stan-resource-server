package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.PessoaJpaEntity;

public interface PessoaRepository extends PagingAndSortingRepository<PessoaJpaEntity, Long> {

	Optional<PessoaJpaEntity> findByCpfOuCnpj(String cpfOuCnpj);

}
