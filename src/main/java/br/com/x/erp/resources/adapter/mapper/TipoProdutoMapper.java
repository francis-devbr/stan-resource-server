package br.com.x.erp.resources.adapter.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.x.erp.resources.adapter.persistence.jpa.entity.produto.TipoProdutoJpaEntity;
import br.com.x.erp.resources.adapter.web.dto.produto.TipoProdutoDTO;
import br.com.x.erp.resources.domain.entity.TipoProduto;

public class TipoProdutoMapper {

	public static TipoProdutoDTO mapToWebDTO(TipoProduto tipoProduto) {
		return Optional.ofNullable(tipoProduto)
				.map(x -> TipoProdutoDTO.builder().id(x.getId()).nome(x.getNome()).build()).orElse(null);
	}

	public static TipoProduto mapToDomainEntity(TipoProdutoJpaEntity tipoProduto) {
		return Optional.ofNullable(tipoProduto).map(x -> TipoProduto.builder().id(x.getId()).nome(x.getNome()).build())
				.orElse(null);
	}

	public static List<TipoProduto> mapToDomainEntity(List<TipoProdutoJpaEntity> tiposProduto) {
		return tiposProduto.stream().map(TipoProdutoMapper::mapToDomainEntity).collect(Collectors.toList());
	}

	public static List<TipoProdutoDTO> mapToWebDTO(List<TipoProduto> tiposProduto) {
		return tiposProduto.stream().map(TipoProdutoMapper::mapToWebDTO).collect(Collectors.toList());
	}

}
