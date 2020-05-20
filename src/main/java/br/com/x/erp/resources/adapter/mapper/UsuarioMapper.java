package br.com.x.erp.resources.adapter.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.x.erp.resources.adapter.persistence.jpa.entity.base.UsuarioJpaEntity;
import br.com.x.erp.resources.adapter.web.dto.acesso.UsuarioDTO;
import br.com.x.erp.resources.domain.entity.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO mapToWebDTO(Usuario usuario) {
	return Optional.ofNullable(usuario)
		.map(x -> UsuarioDTO
			.builder()
			.id(x.getId())
			.username(x.getUsername())
			.password(x.getPassword())
			.regras(RegraMapper.mapToWebDTO(x.getRegras()))
			.isSuperUser(x.getIsSuperUser())
			.isEnable(x.isEnable())
			.build())
		.orElse(null);
    }

    public static Usuario mapToDomainEntity(UsuarioJpaEntity usuario) {
	return Optional.ofNullable(usuario)
		.map(x -> Usuario
			.builder()
			.id(x.getId())
			.username(x.getUsername())
			.password(x.getPassword())
			.regras(RegraMapper.mapToDomainEntity(x.getRegras()))
			.isSuperUser(x.getIsSuperUser())
			.isEnable(x.isEnable())
			.build())
		.orElse(null);
    }

    public static List<Usuario> mapToDomainEntity(List<UsuarioJpaEntity> usuarios) {
	return usuarios.stream().map(UsuarioMapper::mapToDomainEntity).collect(Collectors.toList());
    }

    public static List<UsuarioDTO> mapToWebDTO(List<Usuario> usuarios) {
	return usuarios.stream().map(UsuarioMapper::mapToWebDTO).collect(Collectors.toList());
    }

    public static List<UsuarioJpaEntity> mapToJpaEntity(List<Usuario> usuarios) {
	return usuarios.stream().map(UsuarioMapper::mapToJpaEntity).collect(Collectors.toList());
    }

    public static UsuarioJpaEntity mapToJpaEntity(Usuario usuario) {
	return Optional.ofNullable(usuario)
		.map(x -> UsuarioJpaEntity.builder()
			.id(x.getId())
			.username(x.getUsername())
			.password(x.getPassword())
			.regras(RegraMapper.mapToJpaEntity(x.getRegras()))
			.isSuperUser(x.getIsSuperUser())
			.isEnable(x.isEnable())
			.build())
		.orElse(null);
    }

}
