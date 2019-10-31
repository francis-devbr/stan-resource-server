package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.EstadoJpaEntity;

public interface EstadoRepository extends PagingAndSortingRepository<EstadoJpaEntity, Long> {

	Optional<EstadoJpaEntity> findBySigla(String sigla);

}
