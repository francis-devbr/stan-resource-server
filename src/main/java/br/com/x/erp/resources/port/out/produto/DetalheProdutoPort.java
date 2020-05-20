package br.com.x.erp.resources.port.out.produto;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.x.erp.resources.domain.entity.Produto;

public interface DetalheProdutoPort {
    List<Produto> obterTodos(Pageable pageable);
}
