package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.RegraJpaEntity;

@Repository
public interface RegraRepository extends JpaRepository<RegraJpaEntity, Long> {
	@Transactional(readOnly = true)
	Optional<RegraJpaEntity> findByNome(String name);
}
