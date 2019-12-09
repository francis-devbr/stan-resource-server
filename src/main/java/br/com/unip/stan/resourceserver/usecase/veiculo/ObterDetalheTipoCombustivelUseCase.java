package br.com.unip.stan.resourceserver.usecase.veiculo;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.TipoCombustivel;
import br.com.unip.stan.resourceserver.port.in.veiculo.ObterDetalheTipoCombustivelService;
import br.com.unip.stan.resourceserver.port.out.veiculo.ObterDetalheTipoCombustivelPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalheTipoCombustivelUseCase implements ObterDetalheTipoCombustivelService{
	
	private final ObterDetalheTipoCombustivelPort obterDetalheTipoCombustivelPort;
	
	@Override
	public List<TipoCombustivel> obterTodos() {
		return obterDetalheTipoCombustivelPort.obterTodos();
	}

	@Override
	public TipoCombustivel obter(Long id) {
		return obterDetalheTipoCombustivelPort.obter(id);
	}

}
