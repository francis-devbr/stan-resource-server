package br.com.unip.stan.resourceserver.adapter.persistence.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.mapper.ProdutoMapper;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.produto.ProdutoJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.produto.ProdutoRepository;
import br.com.unip.stan.resourceserver.domain.entity.Produto;
import br.com.unip.stan.resourceserver.port.out.produto.DetalheProdutoPort;

@Component
public class ProdutoPersistenceAdapter implements DetalheProdutoPort {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<Produto> obterTodos() {
		List<ProdutoJpaEntity> entity = produtoRepository.findAll();
		return ProdutoMapper.mapToDomainEntity(entity);
	}

}
