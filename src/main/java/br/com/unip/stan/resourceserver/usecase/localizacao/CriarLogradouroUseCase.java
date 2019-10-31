package br.com.unip.stan.resourceserver.usecase.localizacao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.localizacao.Logradouro;
import br.com.unip.stan.resourceserver.port.in.localizacao.CriarLogradouroService;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdateLogradouroPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarLogradouroUseCase implements CriarLogradouroService{

	private final UpdateLogradouroPort updateLogradouroPort;

	@Override
	public void criar(List<Logradouro> logradouros) {
		updateLogradouroPort.salvar(logradouros);
	}
	
}
