package br.com.unip.stan.resourceserver.usecase.localizacao;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.localizacao.Pais;
import br.com.unip.stan.resourceserver.port.in.localizacao.ObterDetalhePaisService;
import br.com.unip.stan.resourceserver.port.out.localizacao.ObterDetalhePaisPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalhePaisUseCase implements ObterDetalhePaisService {

	private final ObterDetalhePaisPort obterDetalhePaisPort;
	
	@Override
	public Pais findBySigla(String sigla) {
		return obterDetalhePaisPort.findBySigla(sigla);
	}

	
	
	
}
