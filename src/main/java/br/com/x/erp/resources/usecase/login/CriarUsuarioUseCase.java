package br.com.x.erp.resources.usecase.login;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import br.com.x.erp.resources.domain.entity.Regra;
import br.com.x.erp.resources.domain.entity.Usuario;
import br.com.x.erp.resources.port.in.login.CriarUsuarioService;
import br.com.x.erp.resources.port.out.login.ObterDetalheRegraPort;
import br.com.x.erp.resources.port.out.login.ObterDetalheUsuarioPort;
import br.com.x.erp.resources.port.out.login.UpdateUsuarioPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarUsuarioUseCase implements CriarUsuarioService {

	private final UpdateUsuarioPort updateUserPort;
	private final ObterDetalheUsuarioPort obterDadosUserPort;
	private final ObterDetalheRegraPort obterDadosRolePort;

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
