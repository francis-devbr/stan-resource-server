package br.com.unip.stan.resourceserver.usecase.login;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Regra;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Usuario;
import br.com.unip.stan.resourceserver.port.in.login.CriarUsuarioService;
import br.com.unip.stan.resourceserver.port.out.login.ObterDetalheRolePort;
import br.com.unip.stan.resourceserver.port.out.login.ObterDetalheUserPort;
import br.com.unip.stan.resourceserver.port.out.login.UpdateUserPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarUsuarioUseCase implements CriarUsuarioService {

	private final UpdateUserPort updateUserPort;
	private final ObterDetalheUserPort obterDadosUserPort;
	private final ObterDetalheRolePort obterDadosRolePort;

	@Override
	public Usuario createUserIfNotFound(Usuario user, String roleName) {

		Usuario _user = obterDadosUserPort.obter(user.getUsername());

		Regra role = obterDadosRolePort.obter(roleName).orElse(null);

		if (ObjectUtils.isEmpty(_user)) {
			user.setRegras(Arrays.asList(role));
			_user = updateUserPort.salvar(user);
		}

		return _user;

	}

}
