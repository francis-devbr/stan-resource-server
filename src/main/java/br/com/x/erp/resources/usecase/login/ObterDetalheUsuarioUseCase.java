package br.com.x.erp.resources.usecase.login;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.x.erp.resources.domain.entity.Usuario;
import br.com.x.erp.resources.port.in.login.ObterDetalheUsuarioService;
import br.com.x.erp.resources.port.out.login.ObterDetalheUsuarioPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalheUsuarioUseCase implements ObterDetalheUsuarioService {

	private final ObterDetalheUsuarioPort obterDetalheUserPort;

	@Override
	public List<Usuario> buscarTodos() {
		return obterDetalheUserPort.buscarTodos();
	}

	@Override
	public Usuario buscar(String username) {
		return obterDetalheUserPort.obter(username);
	}

}
