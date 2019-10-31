package br.com.unip.stan.resourceserver.adapter.persistence.empresa.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.PessoaMapper;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.ClienteJpaEntity;
import br.com.unip.stan.resourceserver.domain.empresa.Cliente;

public class ClienteMapper {

	public static Optional<Cliente> maptToDomainEntity(Optional<ClienteJpaEntity> clienteJpaEntity) {

		Optional<Cliente> cliente = Optional.empty();

		if (clienteJpaEntity.isPresent()) {
			cliente = Optional.of(maptToDomainEntity(clienteJpaEntity.get()));
		}

		return cliente;
	}

	public static List<Cliente> maptToDomainEntity(Collection<ClienteJpaEntity> clientesJpaEntity) {
		return clientesJpaEntity.stream().map(ClienteMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<ClienteJpaEntity> maptToJpaEntity(Collection<Cliente> clientes) {
		return clientes.stream().map(ClienteMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Cliente maptToDomainEntity(ClienteJpaEntity clienteJpaEntity) {
		return Cliente.builder()
				.id(clienteJpaEntity.getId())
				.pessoa(PessoaMapper.maptToDomainEntity(clienteJpaEntity.getPessoaJpaEntity()))
				.isEnable(clienteJpaEntity.isEnable())
				.build();
	}

	public static ClienteJpaEntity maptToJpaEntity(Cliente cliente) {
		return ClienteJpaEntity.builder()
				.id(cliente.getId())
				.pessoaJpaEntity(PessoaMapper.maptToJpaEntity(cliente.getPessoa()))
				.isEnable(cliente.isEnable())
				.version(0L)
				.build();
	}

}
