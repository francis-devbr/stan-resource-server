package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.produto.ProdutoJpaEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoJpaEntity, Long> {
}
