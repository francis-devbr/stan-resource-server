package br.com.vmx.erp.resourceserver.adapter.mapper;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.vmx.erp.resourceserver.adapter.persistence.jpa.entity.base.PrivilegioJpaEntity;
import br.com.vmx.erp.resourceserver.adapter.web.dto.acesso.PrivilegioDTO;
import br.com.vmx.erp.resourceserver.domain.entity.Privilegio;

public class PrivilegioMapper {

	public static PrivilegioDTO mapToWebDTO(Privilegio privilegio) {
		return Optional.ofNullable(privilegio).map(x -> PrivilegioDTO.builder().id(x.getId()).nome(x.getNome()).build())
				.orElse(null);
	}

	public static Privilegio mapToDomainEntity(PrivilegioJpaEntity privilegio) {
		return Optional.ofNullable(privilegio).map(x -> Privilegio.builder().id(x.getId()).nome(x.getNome()).build())
				.orElse(null);
	}

	public static Collection<Privilegio> mapToDomainEntity(Collection<PrivilegioJpaEntity> privilegios) {
		return privilegios.stream().map(PrivilegioMapper::mapToDomainEntity).collect(Collectors.toList());
	}

	public static Collection<PrivilegioDTO> mapToWebDTO(Collection<Privilegio> privilegios) {
		return privilegios.stream().map(PrivilegioMapper::mapToWebDTO).collect(Collectors.toList());
	}

	public static Collection<PrivilegioJpaEntity> mapToJpaEntity(Collection<Privilegio> privilegios) {
		return privilegios.stream().map(PrivilegioMapper::mapToJpaEntity).collect(Collectors.toList());
	}

	public static PrivilegioJpaEntity mapToJpaEntity(Privilegio privilegios) {
		return Optional.ofNullable(privilegios)
				.map(x -> PrivilegioJpaEntity.builder().id(x.getId()).nome(x.getNome()).build()).orElse(null);
	}

	public static Optional<Privilegio> mapToDomainEntity(Optional<PrivilegioJpaEntity> regra) {
		return regra.map(x -> Privilegio.builder().id(x.getId()).nome(x.getNome()).build());
	}

}
