package br.com.unip.stan.resourceserver.adapter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Usuario;
import br.com.unip.stan.resourceserver.port.in.login.ObterDetalheUsuarioService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/usuarios" })
public class UserController {

	@Autowired
	private ObterDetalheUsuarioService obterDetalheUsuarioService;

	@GetMapping
	@Secured({"ROLE_USER", "ROLE_ADMIN", "ROLE_GUEST"})
	public List<Usuario> firstPage() {
		return obterDetalheUsuarioService.buscarTodos();
	}
	
	@GetMapping("/{username}")
	@Secured({"ROLE_USER", "ROLE_ADMIN", "ROLE_GUEST"})
	public Usuario firstPage(@PathVariable("username") String username) {
		return obterDetalheUsuarioService.buscar(username);
	}


}