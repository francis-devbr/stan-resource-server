package br.com.unip.stan.resourceserver.adapter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unip.stan.resourceserver.domain.empresa.Empresa;
import br.com.unip.stan.resourceserver.port.in.ObterDetalhePessoaService;
import br.com.unip.stan.resourceserver.port.in.empresa.ObterDetalheEmpresaService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/empresas" })
public class EmpresaController {

	@Autowired
	private ObterDetalheEmpresaService obterDetalheEmpresaService;
	
	@Autowired
	private ObterDetalhePessoaService obterDetalhePessoaService;

	@GetMapping(produces = "application/json")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public Empresa firstPage() {
		return obterDetalheEmpresaService.findByPessoa(obterDetalhePessoaService.findByCpfOuCnpj("72907711000155"));
	}


}