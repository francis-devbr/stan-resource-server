package br.com.vmx.erp.resourceserver.usecase.login;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.vmx.erp.resourceserver.domain.entity.Usuario;
import br.com.vmx.erp.resourceserver.port.in.login.ObterDetalheUsuarioService;
import br.com.vmx.erp.resourceserver.port.out.login.ObterDetalheUsuarioPort;
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
