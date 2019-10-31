package br.com.unip.stan.resourceserver.usecase.localizacao;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.localizacao.Logradouro;
import br.com.unip.stan.resourceserver.port.in.localizacao.ObterDetalheLogradouroService;
import br.com.unip.stan.resourceserver.port.out.localizacao.ObterDetalheLogradouroPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalheLogradouroUseCase implements ObterDetalheLogradouroService {

	private final ObterDetalheLogradouroPort obterDetalheLogradouroPort;
	

	@Override
	public Logradouro findByCep(String cep) {
		// TODO Auto-generated method stub
		return obterDetalheLogradouroPort.findByCep(cep);
	}

	
	
	
}
