package br.com.unip.stan.resourceserver.usecase.empresa;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import br.com.unip.stan.resourceserver.domain.empresa.Cargo;
import br.com.unip.stan.resourceserver.port.in.empresa.CriarCargoService;
import br.com.unip.stan.resourceserver.port.out.empresa.ObterDetalheCargoPort;
import br.com.unip.stan.resourceserver.port.out.empresa.UpdateCargoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarCargoUseCase implements CriarCargoService{
	
	private final ObterDetalheCargoPort obterDadosCargoPort;
	private final UpdateCargoPort updateCargoPort;

	@Override
	public Cargo createCargoIfNotFound(String nome) {

		Cargo cargo = obterDadosCargoPort.obter(nome).orElse(null);

		if (ObjectUtils.isEmpty(cargo)) {
			cargo = updateCargoPort.salvar(Cargo.builder().nome(nome).build());
		}

		return cargo;
	}

	
	
}
