package br.com.unip.stan.resourceserver.adapter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unip.stan.resourceserver.domain.veiculo.Veiculo;
import br.com.unip.stan.resourceserver.port.in.ObterDetalhePessoaService;
import br.com.unip.stan.resourceserver.port.in.veiculo.ObterDetalheVeiculoService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/veiculos" })
public class VeiculoController {

	@Autowired
	private ObterDetalheVeiculoService obterDetalheVeiculoService;
	
	@GetMapping(produces = "application/json")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<Veiculo> obterVeiculos() {
		return obterDetalheVeiculoService.obterTodos();
	}


}