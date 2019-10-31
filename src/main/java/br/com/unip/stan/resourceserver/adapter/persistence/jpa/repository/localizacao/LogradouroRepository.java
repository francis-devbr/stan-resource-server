package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.LogradouroJpaEntity;

public interface LogradouroRepository extends PagingAndSortingRepository<LogradouroJpaEntity, Long> {

	Optional<LogradouroJpaEntity> findByCep(String cep);

}
