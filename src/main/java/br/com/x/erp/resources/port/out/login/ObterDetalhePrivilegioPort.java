package br.com.x.erp.resources.port.out.login;

import java.util.Optional;

import br.com.x.erp.resources.domain.entity.Privilegio;

public interface ObterDetalhePrivilegioPort {

	Optional<Privilegio> obter(String name);

}
