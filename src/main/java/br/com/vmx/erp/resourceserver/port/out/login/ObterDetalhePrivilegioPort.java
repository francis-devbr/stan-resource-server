package br.com.vmx.erp.resourceserver.port.out.login;

import java.util.Optional;

import br.com.vmx.erp.resourceserver.domain.entity.Privilegio;

public interface ObterDetalhePrivilegioPort {

	Optional<Privilegio> obter(String name);

}
