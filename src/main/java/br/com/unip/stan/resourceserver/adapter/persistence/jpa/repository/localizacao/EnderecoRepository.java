package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.EnderecoJpaEntity;

public interface EnderecoRepository extends PagingAndSortingRepository<EnderecoJpaEntity, Long> {

}
