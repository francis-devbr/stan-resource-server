package br.com.unip.stan.resourceserver.usecase.veiculo;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.veiculo.Marca;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarMarcaService;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateMarcaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarMarcaUseCase implements CriarMarcaService{

	private final UpdateMarcaPort updateMarcaPort;
	
	@Override
	public Marca criar(Marca marca) {
		return updateMarcaPort.salvar(marca);
	}

}
