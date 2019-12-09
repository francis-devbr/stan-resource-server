package br.com.unip.stan.resourceserver.adapter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Funcionario;
import br.com.unip.stan.resourceserver.port.in.empresa.ObterDetalheFuncionarioService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/funcionarios" })
public class FuncionarioController {

	@Autowired
	private ObterDetalheFuncionarioService obterDetalheFuncionarioService;

	@GetMapping("/{usuario-id}")
	@Secured({"ROLE_USER", "ROLE_ADMIN", "ROLE_GUEST"})
	public Funcionario firstPage(@PathVariable("usuario-id") Long usuarioId) {
		return obterDetalheFuncionarioService.buscar(usuarioId);
	}


}