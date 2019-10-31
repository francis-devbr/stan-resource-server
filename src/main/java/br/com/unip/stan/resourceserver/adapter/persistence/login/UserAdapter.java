package br.com.unip.stan.resourceserver.adapter.persistence.login;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.UsuarioJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.login.UserRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.login.mapper.UserMapper;
import br.com.unip.stan.resourceserver.domain.login.Usuario;
import br.com.unip.stan.resourceserver.port.out.login.ObterDetalheUserPort;
import br.com.unip.stan.resourceserver.port.out.login.UpdateUserPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserAdapter implements ObterDetalheUserPort, UpdateUserPort {

	private final UserRepository userRepository;

	public Optional<Usuario> obter(String username) {
		return UserMapper.maptToDomainEntity(userRepository.findByUsername(username));
	}

	public void salvar(Usuario user) {
		UsuarioJpaEntity usuarioJpaEntity = UserMapper.maptToJpaEntity(user);
		userRepository.save(usuarioJpaEntity);
	}

}