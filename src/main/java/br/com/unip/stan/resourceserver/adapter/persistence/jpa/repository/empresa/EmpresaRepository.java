package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.empresa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	Optional<Empresa> findByCpfOuCnpj(String cpfOuCnpj);

}
