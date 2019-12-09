package br.com.unip.stan.resourceserver.adapter.persistence.empresa;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Cliente;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.empresa.ClienteRepository;
import br.com.unip.stan.resourceserver.port.out.empresa.UpdateClientePort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientePersistenceAdapter implements UpdateClientePort{

	private final ClienteRepository clienteRepository;
	
	@Override
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	
}
