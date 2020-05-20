package br.com.x.erp.resources.adapter.mapper;

import java.util.Optional;

import br.com.x.erp.resources.adapter.persistence.jpa.entity.produto.MarcaJpaEntity;
import br.com.x.erp.resources.adapter.web.dto.produto.MarcaDTO;
import br.com.x.erp.resources.domain.entity.Marca;

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
