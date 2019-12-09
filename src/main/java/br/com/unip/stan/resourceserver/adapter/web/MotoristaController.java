package br.com.unip.stan.resourceserver.adapter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.Motorista;
import br.com.unip.stan.resourceserver.port.in.motorista.ObterDetalheMotoristaService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/motoristas" })
public class MotoristaController {

	@Autowired
	private ObterDetalheMotoristaService obterDetalheMotoristaService;
	
	@GetMapping
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<Motorista> obterMotoristas() {
		return obterDetalheMotoristaService.obterTodos();
	}
	
	@GetMapping(path = "/{cnpj-empresa}")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<Motorista> obterVeiculos(@PathVariable("cnpj-empresa") String cnpj) {
		return obterDetalheMotoristaService.obterTodos(cnpj);
	}
	
	@GetMapping(path = "/{cnpj-empresa}/{id}")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public Motorista obterVeiculos(@PathVariable("cnpj-empresa") String cnpj, @PathVariable("id") Long id) {
		return obterDetalheMotoristaService.obter(cnpj, id);
	}



}