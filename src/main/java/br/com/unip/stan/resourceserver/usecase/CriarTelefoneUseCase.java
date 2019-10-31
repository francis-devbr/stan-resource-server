package br.com.unip.stan.resourceserver.usecase;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.Telefone;
import br.com.unip.stan.resourceserver.port.in.CriarTelefoneService;
import br.com.unip.stan.resourceserver.port.out.UpdateTelefonePort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarTelefoneUseCase implements CriarTelefoneService{

	private final UpdateTelefonePort updateTelefonePort;
	
	public Telefone criar(Telefone telefone) {
		return updateTelefonePort.salvar(telefone);
	}
	
	
}
