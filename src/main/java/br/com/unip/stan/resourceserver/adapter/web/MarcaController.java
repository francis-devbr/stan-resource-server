package br.com.unip.stan.resourceserver.adapter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Marca;
import br.com.unip.stan.resourceserver.port.in.veiculo.ObterDetalheMarcaService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/veiculos/marcas" })
public class MarcaController {

	@Autowired
	private ObterDetalheMarcaService obterDetalheMarcaService;
	
	@GetMapping()
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<Marca> obterMarcas() {
		return obterDetalheMarcaService.obterTodos();
	}
	
	@GetMapping(path = "/{id}")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public Marca obterMarca(@PathVariable("id") Long id) {
		return obterDetalheMarcaService.obter(id);
	}
	

}