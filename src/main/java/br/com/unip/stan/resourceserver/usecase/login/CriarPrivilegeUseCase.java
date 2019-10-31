package br.com.unip.stan.resourceserver.usecase.login;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import br.com.unip.stan.resourceserver.domain.login.Privilege;
import br.com.unip.stan.resourceserver.port.in.login.CriarPrivilegeService;
import br.com.unip.stan.resourceserver.port.out.login.ObterDetalhePrivilegePort;
import br.com.unip.stan.resourceserver.port.out.login.UpdatePrivilegePort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarPrivilegeUseCase implements CriarPrivilegeService {

	private final ObterDetalhePrivilegePort obterDadosPrivilegePort;
	private final UpdatePrivilegePort updatePrivilegePort;

	@Override
	public Privilege createPrivilegeIfNotFound(String name) {

		Privilege privilegio = obterDadosPrivilegePort.obter(name).orElse(null);

		if (ObjectUtils.isEmpty(privilegio)) {
			privilegio = updatePrivilegePort.salvar(Privilege.builder().name(name).build());
		}

		return privilegio;
	}

}
