package br.com.unip.stan.resourceserver.usecase.localizacao;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.localizacao.Estado;
import br.com.unip.stan.resourceserver.port.in.localizacao.ObterDetalheEstadoService;
import br.com.unip.stan.resourceserver.port.out.localizacao.ObterDetalheEstadoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalheEstadoUseCase implements ObterDetalheEstadoService {

	private final ObterDetalheEstadoPort obterDetalheEstadoPort;
	
	@Override
	public Estado findBySigla(String sigla) {
		return obterDetalheEstadoPort.findBySigla(sigla);
	}

	
	
	
}
