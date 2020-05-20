package br.com.x.erp.resources.adapter.mapper;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.x.erp.resources.adapter.persistence.jpa.entity.base.RegraJpaEntity;
import br.com.x.erp.resources.adapter.web.dto.acesso.RegraDTO;
import br.com.x.erp.resources.domain.entity.Regra;

public class RegraMapper {

    public static RegraDTO mapToWebDTO(Regra regra) {
	return Optional.ofNullable(regra)
		.map(x -> RegraDTO
			.builder()
			.id(x.getId())
			.nome(x.getNome())
			.privilegios(PrivilegioMapper.mapToWebDTO(x.getPrivilegios()))
			.build())
		.orElse(null);
    }

    public static Collection<RegraDTO> mapToWebDTO(Collection<Regra> regras) {
	return regras.stream().map(RegraMapper::mapToWebDTO).collect(Collectors.toList());
    }

    public static Regra mapToDomainEntity(RegraJpaEntity regra) {
	return Optional.ofNullable(regra)
		.map(x -> Regra
			.builder()
			.id(x.getId())
			.nome(x.getNome())
			.privilegios(PrivilegioMapper.mapToDomainEntity(x.getPrivilegios()))
			.build())
		.orElse(null);
    }

    public static Collection<Regra> mapToDomainEntity(Collection<RegraJpaEntity> regras) {
	return regras.stream().map(RegraMapper::mapToDomainEntity).collect(Collectors.toList());
    }

    public static Optional<Regra> mapToDomainEntity(Optional<RegraJpaEntity> regra) {
	return regra.map(x -> Regra
		.builder()
		.id(x.getId())
		.nome(x.getNome())
		.privilegios(PrivilegioMapper.mapToDomainEntity(x.getPrivilegios()))
		.build());
    }

    public static Collection<RegraJpaEntity> mapToJpaEntity(Collection<Regra> regras) {
	return regras.stream().map(RegraMapper::mapToJpaEntity).collect(Collectors.toList());
    }

    public static RegraJpaEntity mapToJpaEntity(Regra regra) {
	return Optional.ofNullable(regra)
		.map(x -> RegraJpaEntity
			.builder()
			.id(x.getId())
			.nome(x.getNome())
			.privilegios(PrivilegioMapper.mapToJpaEntity(x.getPrivilegios()))
			.build())
		.orElse(null);
    }

}
