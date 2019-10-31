package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.BairroJpaEntity;

public interface BairroRepository extends PagingAndSortingRepository<BairroJpaEntity, Long> {

}
