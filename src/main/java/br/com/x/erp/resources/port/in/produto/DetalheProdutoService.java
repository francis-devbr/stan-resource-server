package br.com.x.erp.resources.port.in.produto;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.x.erp.resources.domain.entity.Produto;

public interface DetalheProdutoService {

    List<Produto> obterTodos(Pageable pageable);

}
