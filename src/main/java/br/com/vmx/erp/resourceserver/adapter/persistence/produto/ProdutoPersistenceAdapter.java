package br.com.vmx.erp.resourceserver.adapter.persistence.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.vmx.erp.resourceserver.adapter.mapper.ProdutoMapper;
import br.com.vmx.erp.resourceserver.adapter.persistence.jpa.entity.produto.ProdutoJpaEntity;
import br.com.vmx.erp.resourceserver.adapter.persistence.jpa.repository.produto.ProdutoRepository;
import br.com.vmx.erp.resourceserver.domain.entity.Produto;
import br.com.vmx.erp.resourceserver.port.out.produto.DetalheProdutoPort;

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
