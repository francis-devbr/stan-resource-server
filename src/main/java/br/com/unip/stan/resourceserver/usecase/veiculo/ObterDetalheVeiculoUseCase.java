package br.com.unip.stan.resourceserver.usecase.veiculo;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Veiculo;
import br.com.unip.stan.resourceserver.port.in.veiculo.ObterDetalheVeiculoService;
import br.com.unip.stan.resourceserver.port.out.veiculo.ObterDetalheVeiculoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalheVeiculoUseCase implements ObterDetalheVeiculoService{

	private final ObterDetalheVeiculoPort obterDetalheVeiculoPort;
	
	@Override
	public List<Veiculo> obterTodos() {
		return obterDetalheVeiculoPort.obterTodos();
	}

	@Override
	public Veiculo obter(String cnpj, Long id) {
		return obterDetalheVeiculoPort.obter(cnpj, id);
	}

}
