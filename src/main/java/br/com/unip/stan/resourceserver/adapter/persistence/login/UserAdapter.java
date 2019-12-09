package br.com.unip.stan.resourceserver.adapter.persistence.login;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Usuario;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.login.UserRepository;
import br.com.unip.stan.resourceserver.port.out.login.ObterDetalheUserPort;
import br.com.unip.stan.resourceserver.port.out.login.UpdateUserPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserAdapter implements ObterDetalheUserPort, UpdateUserPort {

	private final UserRepository userRepository;

	public Usuario obter(String username) {
		return userRepository.findByUsername(username).orElse(null);
	}

	public Usuario salvar(Usuario user) {

		return userRepository.save(user);

	}

	public List<Usuario> buscarTodos() {
		return userRepository.findAll();
	}

}