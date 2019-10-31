package br.com.unip.stan.resourceserver.usecase.veiculo;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.veiculo.Veiculo;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarVeiculoService;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateVeiculoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarVeiculoUseCase implements CriarVeiculoService{

	private final UpdateVeiculoPort updateVeiculoPort;
	
	public Veiculo criar(Veiculo veiculo) {
		return updateVeiculoPort.salvar(veiculo);
	}
	
	
}
