package br.com.unip.stan.resourceserver.usecase.veiculo;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Marca;
import br.com.unip.stan.resourceserver.port.in.veiculo.ObterDetalheMarcaService;
import br.com.unip.stan.resourceserver.port.out.veiculo.ObterDetalheMarcaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalheMarcaUseCase implements ObterDetalheMarcaService {

	private final ObterDetalheMarcaPort obterDetalheMarcaPort;

	@Override
	public List<Marca> obterTodos() {
		return obterDetalheMarcaPort.obterTodos();
	}

	@Override
	public Marca obter(Long id) {
		return obterDetalheMarcaPort.obter(id);
	}

}
