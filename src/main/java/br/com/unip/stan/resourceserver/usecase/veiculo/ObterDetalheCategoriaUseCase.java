package br.com.unip.stan.resourceserver.usecase.veiculo;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Categoria;
import br.com.unip.stan.resourceserver.port.in.veiculo.ObterDetalheCategoriaService;
import br.com.unip.stan.resourceserver.port.out.veiculo.ObterDetalheCategoriaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalheCategoriaUseCase implements ObterDetalheCategoriaService{
	
	private final ObterDetalheCategoriaPort obterDetalheCategoriaPort;
	
	@Override
	public List<Categoria> obterTodos() {
		return obterDetalheCategoriaPort.obterTodos();
	}

	@Override
	public Categoria obter(Long id) {
		return obterDetalheCategoriaPort.obter(id);
	}

}
