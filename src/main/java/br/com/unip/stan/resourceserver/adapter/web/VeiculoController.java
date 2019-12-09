package br.com.unip.stan.resourceserver.adapter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Veiculo;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarVeiculoService;
import br.com.unip.stan.resourceserver.port.in.veiculo.ObterDetalheVeiculoService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/veiculos" })
public class VeiculoController {

	@Autowired
	private ObterDetalheVeiculoService obterDetalheVeiculoService;
	
	@Autowired
	private CriarVeiculoService criarVeiculoService;
	
	@GetMapping()
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<Veiculo> obterVeiculos() {
		return obterDetalheVeiculoService.obterTodos();
	}
	
	@GetMapping(path = "/{cnpj-empresa}")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<Veiculo> obterVeiculos(@PathVariable("cnpj-empresa") String cnpj) {
		return obterDetalheVeiculoService.obterTodos();
	}
	
	@GetMapping(path = "/{cnpj-empresa}/{id}")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public Veiculo obterVeiculos(@PathVariable("cnpj-empresa") String cnpj, @PathVariable("id") Long id) {
		return obterDetalheVeiculoService.obter(cnpj, id);
	}
	
	@PostMapping()
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public Veiculo criarVeiculo(@RequestBody Veiculo veiculo) {
		
		System.out.println("teste");
		System.out.println(veiculo);
		return criarVeiculoService.criar(veiculo);
	}
	
	@PostMapping("/{id}")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public Veiculo atualizarVeiculo(@PathVariable("id") Long id, @RequestBody Veiculo veiculo) {
		
		System.out.println("teste");
		System.out.println(veiculo);
		return criarVeiculoService.criar(veiculo);
	}
	

}