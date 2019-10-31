package br.com.unip.stan.resourceserver.usecase.localizacao;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.localizacao.TipoLogradouro;
import br.com.unip.stan.resourceserver.port.in.localizacao.ObterDetalheTipoLogradouroService;
import br.com.unip.stan.resourceserver.port.out.localizacao.ObterDetalheTipoLogradouroPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalheTipoLogradouroUseCase implements ObterDetalheTipoLogradouroService{

	private final ObterDetalheTipoLogradouroPort obterDetalheTipoLogradouroPort;
	
	@Override
	public TipoLogradouro findByNome(String nome) {
		return obterDetalheTipoLogradouroPort.findByNome(nome);
	}

}
