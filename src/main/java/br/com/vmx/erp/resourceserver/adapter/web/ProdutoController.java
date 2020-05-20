package br.com.vmx.erp.resourceserver.adapter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vmx.erp.resourceserver.adapter.mapper.ProdutoMapper;
import br.com.vmx.erp.resourceserver.adapter.web.dto.produto.ProdutoDTO;
import br.com.vmx.erp.resourceserver.domain.entity.Produto;
import br.com.vmx.erp.resourceserver.port.in.produto.DetalheProdutoService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/produtos" })
public class ProdutoController {

    @Autowired
    private DetalheProdutoService produtoService;

    @GetMapping()
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    public List<ProdutoDTO> obterProdutos(Pageable pageable) {
	List<Produto> produto = produtoService.obterTodos(pageable);
	return ProdutoMapper.mapToWebDTO(produto);
    }

}