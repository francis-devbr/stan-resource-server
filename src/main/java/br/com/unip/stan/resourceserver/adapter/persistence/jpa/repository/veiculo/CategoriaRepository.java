package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.CategoriaJpaEntity;

public interface CategoriaRepository extends PagingAndSortingRepository<CategoriaJpaEntity, Long> {

}
