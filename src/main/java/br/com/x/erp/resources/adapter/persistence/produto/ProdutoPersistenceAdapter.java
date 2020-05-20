package br.com.x.erp.resources.adapter.persistence.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.x.erp.resources.adapter.mapper.ProdutoMapper;
import br.com.x.erp.resources.adapter.persistence.jpa.entity.produto.ProdutoJpaEntity;
import br.com.x.erp.resources.adapter.persistence.jpa.repository.produto.ProdutoRepository;
import br.com.x.erp.resources.domain.entity.Produto;
import br.com.x.erp.resources.port.out.produto.DetalheProdutoPort;

@Component
public class ProdutoPersistenceAdapter implements DetalheProdutoPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> obterTodos(Pageable pageable) {
	Page<ProdutoJpaEntity> produtos = produtoRepository.findAll(pageable);
	return produtos.map(x -> ProdutoMapper.mapToDomainEntity(x)).toList();
    }

}
