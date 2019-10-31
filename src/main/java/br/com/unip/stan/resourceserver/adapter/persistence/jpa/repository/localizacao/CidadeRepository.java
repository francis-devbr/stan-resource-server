package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.CidadeJpaEntity;

public interface CidadeRepository extends PagingAndSortingRepository<CidadeJpaEntity, Long> {

}
