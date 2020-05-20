package br.com.x.erp.resources.adapter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.x.erp.resources.adapter.mapper.UsuarioMapper;
import br.com.x.erp.resources.adapter.web.dto.acesso.UsuarioDTO;
import br.com.x.erp.resources.domain.entity.Usuario;
import br.com.x.erp.resources.port.in.login.ObterDetalheUsuarioService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/usuarios" })
public class UsuarioController {

    @Autowired
    private ObterDetalheUsuarioService obterDetalheUsuarioService;

    @GetMapping
    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_GUEST" })
    public List<UsuarioDTO> firstPage() {
	List<Usuario> usuarios = obterDetalheUsuarioService.buscarTodos();
	return UsuarioMapper.mapToWebDTO(usuarios);
    }

    @GetMapping("/{username}")
    @Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_GUEST" })
    public UsuarioDTO firstPage(@PathVariable("username") String username) {
	Usuario usuario = obterDetalheUsuarioService.buscar(username);
	return UsuarioMapper.mapToWebDTO(usuario);
    }

}