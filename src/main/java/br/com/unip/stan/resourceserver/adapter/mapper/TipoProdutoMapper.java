package br.com.unip.stan.resourceserver.adapter.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.produto.TipoProdutoJpaEntity;
import br.com.unip.stan.resourceserver.adapter.web.dto.produto.TipoProdutoDTO;
import br.com.unip.stan.resourceserver.domain.entity.TipoProduto;

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
