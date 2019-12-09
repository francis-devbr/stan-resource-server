package br.com.unip.stan.resourceserver.port.in.empresa;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Cliente;

public interface CriarClienteService {

	Cliente criar(Cliente cliente);

}
