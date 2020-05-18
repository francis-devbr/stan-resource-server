package br.com.unip.stan.resourceserver.adapter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unip.stan.resourceserver.adapter.mapper.ProdutoMapper;
import br.com.unip.stan.resourceserver.adapter.web.dto.produto.ProdutoDTO;
import br.com.unip.stan.resourceserver.domain.entity.Produto;
import br.com.unip.stan.resourceserver.port.in.produto.DetalheProdutoService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/produtos" })
public class ProdutoController {

    @Autowired
    private DetalheProdutoService produtoService;

    @GetMapping()
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    public List<ProdutoDTO> obterVeiculos() {
	List<Produto> produto = produtoService.obterTodos();
	return ProdutoMapper.mapToWebDTO(produto);
    }

}