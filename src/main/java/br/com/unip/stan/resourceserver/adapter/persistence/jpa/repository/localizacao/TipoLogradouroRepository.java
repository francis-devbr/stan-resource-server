package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.TipoLogradouroJpaEntity;

public interface TipoLogradouroRepository extends PagingAndSortingRepository<TipoLogradouroJpaEntity, Long> {

	Optional<TipoLogradouroJpaEntity> findByNome(String nome);

}
