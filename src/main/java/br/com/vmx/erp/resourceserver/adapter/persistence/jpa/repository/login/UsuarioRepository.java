package br.com.vmx.erp.resourceserver.adapter.persistence.jpa.repository.login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vmx.erp.resourceserver.adapter.persistence.jpa.entity.base.UsuarioJpaEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioJpaEntity, Long> {

	@Transactional(readOnly = true)
	Optional<UsuarioJpaEntity> findByUsername(String username);
}
