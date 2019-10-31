package br.com.unip.stan.resourceserver.usecase.localizacao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.localizacao.TipoLogradouro;
import br.com.unip.stan.resourceserver.port.in.localizacao.CriarTipoLogradouroService;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdateTipoLogradouroPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarTipoLogradouroUseCase implements CriarTipoLogradouroService {

	private final UpdateTipoLogradouroPort updateTipoLogradouroPort;

	@Override
	public void criar(List<TipoLogradouro> tiposLogradouro) {
		updateTipoLogradouroPort.salvar(tiposLogradouro);
	}

}
