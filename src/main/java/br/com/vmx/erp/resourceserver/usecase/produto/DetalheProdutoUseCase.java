package br.com.vmx.erp.resourceserver.usecase.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.vmx.erp.resourceserver.domain.entity.Produto;
import br.com.vmx.erp.resourceserver.port.in.produto.DetalheProdutoService;
import br.com.vmx.erp.resourceserver.port.out.produto.DetalheProdutoPort;

@Component
public class DetalheProdutoUseCase implements DetalheProdutoService {

    @Autowired
    private DetalheProdutoPort produtoPort;

    @Override
    public List<Produto> obterTodos(Pageable pageable) {
	return produtoPort.obterTodos(pageable);
    }

}
