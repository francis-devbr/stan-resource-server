package br.com.unip.stan.resourceserver.usecase;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.Contato;
import br.com.unip.stan.resourceserver.port.in.CriarContatoService;
import br.com.unip.stan.resourceserver.port.out.UpdateContatoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarContatoUseCase implements CriarContatoService{

	private final UpdateContatoPort updateContatoPort;
	
	public Contato criar(Contato contato) {
		return updateContatoPort.salvar(contato);
	}
	
	
}
