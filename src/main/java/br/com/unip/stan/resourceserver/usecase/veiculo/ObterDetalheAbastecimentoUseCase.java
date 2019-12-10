package br.com.unip.stan.resourceserver.usecase.veiculo;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Abastecimento;
import br.com.unip.stan.resourceserver.port.in.veiculo.ObterDetalheAbastecimentoService;
import br.com.unip.stan.resourceserver.port.out.veiculo.ObterDetalheAbastecimentoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalheAbastecimentoUseCase implements ObterDetalheAbastecimentoService{

	private final ObterDetalheAbastecimentoPort obterDetalheAbastecimentoPort;

	@Override
	public Abastecimento obter(String cnpj, Long id) {
		return obterDetalheAbastecimentoPort.obter(cnpj, id);
	}

	@Override
	public List<Abastecimento> obterTodos(String cnpj) {
		return obterDetalheAbastecimentoPort.obterTodos(cnpj);
	}
	
	

}
