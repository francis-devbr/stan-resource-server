package br.com.unip.stan.resourceserver.usecase.veiculo;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.veiculo.TipoCombustivel;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarTipoCombustivelService;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateTipoCombustivelPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarTipoCombustivelUseCase implements CriarTipoCombustivelService{

	private final UpdateTipoCombustivelPort updateTipoCombustivelPort;
	
	@Override
	public TipoCombustivel criar(TipoCombustivel tipoCombustivel) {
		return updateTipoCombustivelPort.salvar(tipoCombustivel);
	}

}
