package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.empresa;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

}
