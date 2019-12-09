package br.com.unip.stan.resourceserver.port.out.empresa;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Cliente;

public interface UpdateClientePort {

	Cliente salvar(Cliente categoria);

}
