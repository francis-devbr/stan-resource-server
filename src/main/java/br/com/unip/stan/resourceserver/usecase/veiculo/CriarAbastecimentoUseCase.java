package br.com.unip.stan.resourceserver.usecase.veiculo;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Abastecimento;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarAbastecimentoService;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateAbastecimentoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarAbastecimentoUseCase implements CriarAbastecimentoService{

	private final UpdateAbastecimentoPort updateAbastecimentoPort;
	
	public Abastecimento criar(Abastecimento abastecimento) {
		return updateAbastecimentoPort.salvar(abastecimento);
	}
	
	
}
