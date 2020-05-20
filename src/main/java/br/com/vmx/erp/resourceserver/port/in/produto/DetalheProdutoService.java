package br.com.vmx.erp.resourceserver.port.in.produto;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.vmx.erp.resourceserver.domain.entity.Produto;

public interface DetalheProdutoService {

    List<Produto> obterTodos(Pageable pageable);

}
