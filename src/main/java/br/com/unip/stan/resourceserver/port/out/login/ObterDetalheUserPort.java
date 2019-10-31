package br.com.unip.stan.resourceserver.port.out.login;

import java.util.Optional;

import br.com.unip.stan.resourceserver.domain.login.Usuario;

public interface ObterDetalheUserPort {

	Optional<Usuario> obter(String username);

}
