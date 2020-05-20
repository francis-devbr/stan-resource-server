package br.com.vmx.erp.resourceserver.adapter.persistence.jpa.repository.produto;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.vmx.erp.resourceserver.adapter.persistence.jpa.entity.produto.ProdutoJpaEntity;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<ProdutoJpaEntity, Long> {
}
