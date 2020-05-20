package br.com.vmx.erp.resourceserver.adapter.mapper;

import java.util.Optional;

import br.com.vmx.erp.resourceserver.adapter.persistence.jpa.entity.produto.MarcaJpaEntity;
import br.com.vmx.erp.resourceserver.adapter.web.dto.produto.MarcaDTO;
import br.com.vmx.erp.resourceserver.domain.entity.Marca;

public class MarcaMapper {

	public static MarcaDTO mapToWebDTO(Marca marca) {
		return Optional.ofNullable(marca).map(x -> MarcaDTO.builder().id(x.getId()).nome(x.getNome()).build())
				.orElse(null);
	}

	public static Marca mapToDomainEntity(MarcaJpaEntity marca) {
		return Optional.ofNullable(marca).map(x -> Marca.builder().id(x.getId()).nome(x.getNome()).build())
				.orElse(null);
	}
}
