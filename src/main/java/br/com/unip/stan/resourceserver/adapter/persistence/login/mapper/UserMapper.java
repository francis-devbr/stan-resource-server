package br.com.unip.stan.resourceserver.adapter.persistence.login.mapper;

import java.util.Optional;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.UsuarioJpaEntity;
import br.com.unip.stan.resourceserver.domain.login.Usuario;

public class UserMapper {

	public static Optional<Usuario> maptToDomainEntity(Optional<UsuarioJpaEntity> usuarioJpaEntity) {

		Optional<Usuario> usuario = Optional.empty();

		if (usuarioJpaEntity.isPresent()) {
			usuario = Optional.of(maptToDomainEntity(usuarioJpaEntity.get()));
		}

		return usuario;
	}

	public static Usuario maptToDomainEntity(UsuarioJpaEntity usuarioJpaEntity) {
		return Usuario.builder()
				.id(usuarioJpaEntity.getId())
				.username(usuarioJpaEntity.getUsername())
				.password(usuarioJpaEntity.getPassword())
				.roles(RoleMapper.maptToDomainEntity(usuarioJpaEntity.getRegrasJpaEntity()))
				.isEnable(usuarioJpaEntity.isEnable())
				.build();
	}

	public static UsuarioJpaEntity maptToJpaEntity(Usuario usuario) {
		return UsuarioJpaEntity.builder()
				.id(usuario.getId()).username(usuario.getUsername())
				.password(usuario.getPassword()).regrasJpaEntity(RoleMapper.maptToJpaEntity(usuario.getRoles()))
				.version(0L)
				.isEnable(usuario.isEnable()).build();
	}

}
