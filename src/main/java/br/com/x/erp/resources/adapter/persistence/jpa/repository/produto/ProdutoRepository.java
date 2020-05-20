package br.com.x.erp.resources.adapter.persistence.jpa.repository.produto;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.x.erp.resources.adapter.persistence.jpa.entity.produto.ProdutoJpaEntity;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<ProdutoJpaEntity, Long> {
}
