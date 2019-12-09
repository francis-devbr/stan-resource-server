package br.com.unip.stan.resourceserver.adapter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Categoria;
import br.com.unip.stan.resourceserver.port.in.veiculo.ObterDetalheCategoriaService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/veiculos/categorias" })
public class CategoriaController {

	@Autowired
	private ObterDetalheCategoriaService obterDetalheCategoriaService;
	
	@GetMapping()
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<Categoria> obterCategorias() {
		return obterDetalheCategoriaService.obterTodos();
	}
	
	@GetMapping(path = "/{id}")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public Categoria obterCategoria(@PathVariable("id") Long id) {
		return obterDetalheCategoriaService.obter(id);
	}
	

}