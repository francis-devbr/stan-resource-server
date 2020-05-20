package br.com.vmx.erp.resourceserver.adapter.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.vmx.erp.resourceserver.adapter.persistence.jpa.entity.produto.ProdutoJpaEntity;
import br.com.vmx.erp.resourceserver.adapter.web.dto.produto.ProdutoDTO;
import br.com.vmx.erp.resourceserver.domain.entity.Produto;

public class ProdutoMapper {

	public static List<ProdutoDTO> mapToWebDTO(List<Produto> produtos) {
		return produtos.stream().map(ProdutoMapper::mapToWebDTO).collect(Collectors.toList());
	}

	public static ProdutoDTO mapToWebDTO(Produto produto) {
		return Optional.ofNullable(produto)
				.map(x -> ProdutoDTO.builder()
						.id(x.getId())
						.nome(x.getNome())
						.complemento1(x.getComplemento1())
						.complemento2(x.getComplemento2())
						.descricaoCupom(x.getDescricaoCupom())
						.descricaoGondola(x.getDescricaoGondola())
						.marca(MarcaMapper.mapToWebDTO(x.getMarca()))
						.tiposProduto(TipoProdutoMapper.mapToWebDTO(x.getTiposProduto()))
						.build())
				.orElse(null);
	}

	public static List<Produto> mapToDomainEntity(List<ProdutoJpaEntity> produtos) {
		return produtos.stream().map(ProdutoMapper::mapToDomainEntity).collect(Collectors.toList());
	}
	
	public static Produto mapToDomainEntity(ProdutoJpaEntity produto) {
		return Optional.ofNullable(produto)
				.map(x -> Produto.builder()
						.id(x.getId())
						.nome(x.getNome())
						.complemento1(x.getComplemento1())
						.complemento2(x.getComplemento2())
						.descricaoCupom(x.getDescricaoCupom())
						.descricaoGondola(x.getDescricaoGondola())
						.marca(MarcaMapper.mapToDomainEntity(x.getMarca()))
						.tiposProduto(TipoProdutoMapper.mapToDomainEntity(x.getTiposProduto()))
						.build())
				.orElse(null);
		
	}

}
