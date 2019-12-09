package br.com.unip.stan.resourceserver.usecase.login;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Usuario;
import br.com.unip.stan.resourceserver.port.in.login.ObterDetalheUsuarioService;
import br.com.unip.stan.resourceserver.port.out.login.ObterDetalheUserPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalheUsuarioUseCase implements ObterDetalheUsuarioService {

	private final ObterDetalheUserPort obterDetalheUserPort;

	@Override
	public List<Usuario> buscarTodos() {
		return obterDetalheUserPort.buscarTodos();
	}

	@Override
	public Usuario buscar(String username) {
		return obterDetalheUserPort.obter(username);
	}

}
