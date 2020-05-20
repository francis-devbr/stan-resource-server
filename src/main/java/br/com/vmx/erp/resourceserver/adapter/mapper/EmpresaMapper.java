package br.com.vmx.erp.resourceserver.adapter.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.vmx.erp.resourceserver.adapter.persistence.jpa.entity.empresa.EmpresaJpaEntity;
import br.com.vmx.erp.resourceserver.adapter.web.dto.empresa.EmpresaDTO;
import br.com.vmx.erp.resourceserver.domain.entity.Empresa;

public class EmpresaMapper {

    public static EmpresaDTO mapToWebDTO(Empresa empresa) {
	return Optional.ofNullable(empresa)
		.map(x -> EmpresaDTO
			.builder()
			.id(x.getId())
			.nome(x.getNome())
			.build())
		.orElse(null);
    }

    public static Empresa mapToDomainEntity(EmpresaJpaEntity empresa) {
	return Optional.ofNullable(empresa).map(x -> Empresa.builder().id(x.getId()).nome(x.getNome()).build())
		.orElse(null);
    }

    public static List<Empresa> mapToDomainEntity(List<EmpresaJpaEntity> empresas) {
	return empresas.stream().map(EmpresaMapper::mapToDomainEntity).collect(Collectors.toList());
    }

    public static List<EmpresaDTO> mapToWebDTO(List<Empresa> empresas) {
	return empresas.stream().map(EmpresaMapper::mapToWebDTO).collect(Collectors.toList());
    }

}
