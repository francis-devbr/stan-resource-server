package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.motorista;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.MotoristaJpaEntity;

public interface MotoristaRepository extends PagingAndSortingRepository<MotoristaJpaEntity, Long> {

}
