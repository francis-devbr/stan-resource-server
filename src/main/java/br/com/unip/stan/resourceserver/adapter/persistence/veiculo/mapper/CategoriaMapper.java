package br.com.unip.stan.resourceserver.adapter.persistence.veiculo.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.CategoriaJpaEntity;
import br.com.unip.stan.resourceserver.domain.veiculo.Categoria;

public class CategoriaMapper {

	public static Optional<Categoria> maptToDomainEntity(Optional<CategoriaJpaEntity> categoriaJpaEntity) {

		Optional<Categoria> categoria = Optional.empty();

		if (categoriaJpaEntity.isPresent()) {
			categoria = Optional.of(maptToDomainEntity(categoriaJpaEntity.get()));
		}

		return categoria;
	}

	public static List<Categoria> maptToDomainEntity(Collection<CategoriaJpaEntity> categoriasJpaEntity) {
		return categoriasJpaEntity.stream().map(CategoriaMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<CategoriaJpaEntity> maptToJpaEntity(Collection<Categoria> categorias) {
		return categorias.stream().map(CategoriaMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Categoria maptToDomainEntity(CategoriaJpaEntity categoriaJpaEntity) {
		return Categoria.builder()
				.id(categoriaJpaEntity.getId())
				.nome(categoriaJpaEntity.getNome())
				.isEnable(categoriaJpaEntity.isEnable())
				.build();
	}

	public static CategoriaJpaEntity maptToJpaEntity(Categoria categoria) {
		return CategoriaJpaEntity.builder()
				.id(categoria.getId())
				.nome(categoria.getNome())
				.isEnable(categoria.isEnable())
				.version(0L)
				.build();
	}

}
