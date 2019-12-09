package br.com.unip.stan.resourceserver.usecase.empresa;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Cliente;
import br.com.unip.stan.resourceserver.port.in.empresa.CriarClienteService;
import br.com.unip.stan.resourceserver.port.out.empresa.UpdateClientePort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarClienteUseCase implements CriarClienteService{

	private final UpdateClientePort updateClientePort;
	
	public Cliente criar(Cliente cliente) {
		return updateClientePort.salvar(cliente);
	}
	
	
}
