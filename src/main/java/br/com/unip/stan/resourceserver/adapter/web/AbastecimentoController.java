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

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Abastecimento;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarAbastecimentoService;
import br.com.unip.stan.resourceserver.port.in.veiculo.ObterDetalheAbastecimentoService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/abastecimentos" })
public class AbastecimentoController {

	@Autowired
	private ObterDetalheAbastecimentoService obterDetalheAbastecimentoService;
	
	@Autowired
	private CriarAbastecimentoService criarAbastecimentoService;
	
	
	@GetMapping(path = "/{cnpj-empresa}")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<Abastecimento> obterAbastecimentos(@PathVariable("cnpj-empresa") String cnpj) {
		return obterDetalheAbastecimentoService.obterTodos(cnpj);
	}
	
	@GetMapping(path = "/{cnpj-empresa}/{id}")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public Abastecimento obterAbastecimentos(@PathVariable("cnpj-empresa") String cnpj, @PathVariable("id") Long id) {
		return obterDetalheAbastecimentoService.obter(cnpj, id);
	}
	
	@PostMapping()
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public Abastecimento criarAbastecimento(@RequestBody Abastecimento abastecimento) {
		
		return criarAbastecimentoService.criar(abastecimento);
	}
	
	@PostMapping("/{id}")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public Abastecimento atualizarAbastecimento(@PathVariable("id") Long id, @RequestBody Abastecimento abastecimento) {
		
		return criarAbastecimentoService.criar(abastecimento);
	}
	

}