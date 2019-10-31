package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.ContatoJpaEntity;

public interface ContatoRepository extends PagingAndSortingRepository<ContatoJpaEntity, Long> {

}
