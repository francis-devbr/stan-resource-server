package br.com.x.erp.resources.usecase.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.x.erp.resources.domain.entity.Produto;
import br.com.x.erp.resources.port.in.produto.DetalheProdutoService;
import br.com.x.erp.resources.port.out.produto.DetalheProdutoPort;

@Component
public class DetalheProdutoUseCase implements DetalheProdutoService {

    @Autowired
    private DetalheProdutoPort produtoPort;

    @Override
    public List<Produto> obterTodos(Pageable pageable) {
	return produtoPort.obterTodos(pageable);
    }

}
