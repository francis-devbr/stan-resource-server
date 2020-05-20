package br.com.vmx.erp.resourceserver.usecase.login;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import br.com.vmx.erp.resourceserver.domain.entity.Regra;
import br.com.vmx.erp.resourceserver.domain.entity.Usuario;
import br.com.vmx.erp.resourceserver.port.in.login.CriarUsuarioService;
import br.com.vmx.erp.resourceserver.port.out.login.ObterDetalheRegraPort;
import br.com.vmx.erp.resourceserver.port.out.login.ObterDetalheUsuarioPort;
import br.com.vmx.erp.resourceserver.port.out.login.UpdateUsuarioPort;
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
