package br.com.vmx.erp.resourceserver.port.out.produto;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.vmx.erp.resourceserver.domain.entity.Produto;

public interface DetalheProdutoPort {
    List<Produto> obterTodos(Pageable pageable);
}
