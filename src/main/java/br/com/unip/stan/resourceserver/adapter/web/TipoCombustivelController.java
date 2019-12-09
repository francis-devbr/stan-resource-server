package br.com.unip.stan.resourceserver.adapter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.TipoCombustivel;
import br.com.unip.stan.resourceserver.port.in.veiculo.ObterDetalheTipoCombustivelService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/veiculos/combustiveis" })
public class TipoCombustivelController {

	@Autowired
	private ObterDetalheTipoCombustivelService obterDetalheTipoCombustivelService;
	
	@GetMapping()
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<TipoCombustivel> obterVeiculos() {
		return obterDetalheTipoCombustivelService.obterTodos();
	}
	
	@GetMapping(path = "/{id}")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public TipoCombustivel obterVeiculos(@PathVariable("id") Long id) {
		return obterDetalheTipoCombustivelService.obter(id);
	}
	

}