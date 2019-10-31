package br.com.unip.stan.resourceserver.adapter.persistence.veiculo;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.CategoriaJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo.CategoriaRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.veiculo.mapper.CategoriaMapper;
import br.com.unip.stan.resourceserver.domain.veiculo.Categoria;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateCategoriaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoriaPersistenceAdapter implements UpdateCategoriaPort{

	private final CategoriaRepository categoriaRepository;
	
	@Override
	public Categoria salvar(Categoria categoria) {
		CategoriaJpaEntity privilegeJpaEntity = CategoriaMapper.maptToJpaEntity(categoria);
		Categoria categoriaDomain = CategoriaMapper.maptToDomainEntity(categoriaRepository.save(privilegeJpaEntity));
		return categoriaDomain;
	}

	
}
