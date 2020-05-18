package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.PrivilegioJpaEntity;

@Repository
public interface PrivilegioRepository extends JpaRepository<PrivilegioJpaEntity, Long> {

	Optional<PrivilegioJpaEntity> findByNome(String name);

}
