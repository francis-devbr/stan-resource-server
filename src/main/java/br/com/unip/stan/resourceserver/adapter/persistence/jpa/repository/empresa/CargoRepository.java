package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.empresa;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Cargo;

public interface CargoRepository extends PagingAndSortingRepository<Cargo, Long> {

	Optional<Cargo> findByNome(String nome);

}
