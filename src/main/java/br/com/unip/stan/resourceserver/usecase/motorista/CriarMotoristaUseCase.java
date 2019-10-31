package br.com.unip.stan.resourceserver.usecase.motorista;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.motorista.Motorista;
import br.com.unip.stan.resourceserver.port.in.motorista.CriarMotoristaService;
import br.com.unip.stan.resourceserver.port.out.motorista.UpdateMotoristaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarMotoristaUseCase implements CriarMotoristaService {

	private final UpdateMotoristaPort updateMotoristaPort;

	@Override
	public Motorista criar(Motorista motorista) {
		return updateMotoristaPort.salvar(motorista);
	}

}
