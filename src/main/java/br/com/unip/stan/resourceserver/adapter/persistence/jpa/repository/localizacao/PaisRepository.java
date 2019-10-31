package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.PaisJpaEntity;

public interface PaisRepository extends PagingAndSortingRepository<PaisJpaEntity, Long> {

	Optional<PaisJpaEntity> findBySigla(String sigla);

}
