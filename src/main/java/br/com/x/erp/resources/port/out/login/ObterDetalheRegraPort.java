package br.com.x.erp.resources.port.out.login;

import java.util.Optional;

import br.com.x.erp.resources.domain.entity.Regra;

public interface ObterDetalheRegraPort {

	Optional<Regra> obter(String roleName);

}
