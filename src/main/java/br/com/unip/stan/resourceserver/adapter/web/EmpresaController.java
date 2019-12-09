package br.com.unip.stan.resourceserver.adapter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Empresa;
import br.com.unip.stan.resourceserver.port.in.empresa.ObterDetalheEmpresaService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/empresas" })
public class EmpresaController {

	@Autowired
	private ObterDetalheEmpresaService obterDetalheEmpresaService;

	@GetMapping(path = "/{cnpj}")
	@Secured({"ROLE_USER", "ROLE_ADMIN", "ROLE_GUEST"})
	public Empresa firstPage(@PathVariable("cnpj") String cnpj) {
		return obterDetalheEmpresaService.findByCnpj(cnpj);
	}
	
	@GetMapping
	@Secured({"ROLE_USER", "ROLE_ADMIN", "ROLE_GUEST"})
	public List<Empresa> firstPage() {
		return obterDetalheEmpresaService.buscarTodos();
	}


}