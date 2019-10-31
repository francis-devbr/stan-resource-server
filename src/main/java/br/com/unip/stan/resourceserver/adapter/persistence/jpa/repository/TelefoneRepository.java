package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.TelefoneJpaEntity;

public interface TelefoneRepository extends PagingAndSortingRepository<TelefoneJpaEntity, Long> {

}
