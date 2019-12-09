package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Regra;

@Repository
public interface RoleRepository extends JpaRepository<Regra, Long> {
	@Transactional(readOnly = true)
	Optional<Regra> findByNome(String name);
}
