package br.com.unip.stan.resourceserver.adapter.persistence.veiculo;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Categoria;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo.CategoriaRepository;
import br.com.unip.stan.resourceserver.port.out.veiculo.ObterDetalheCategoriaPort;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateCategoriaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoriaPersistenceAdapter implements UpdateCategoriaPort, ObterDetalheCategoriaPort {

	private final CategoriaRepository categoriaRepository;

	@Override
	public Categoria salvar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> obterTodos() {
		return categoriaRepository.findAll();
	}

	public Categoria obter(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}
	

}
