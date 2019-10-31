package br.com.unip.stan.resourceserver.usecase.veiculo;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.veiculo.Modelo;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarModeloService;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateModeloPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarModeloUseCase implements CriarModeloService{

	private final UpdateModeloPort updateModeloPort;
	
	@Override
	public Modelo criar(Modelo modelo) {
		return updateModeloPort.salvar(modelo);
	}

}
