package br.com.vmx.erp.resourceserver.adapter.persistence.jpa.repository.empresa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vmx.erp.resourceserver.adapter.persistence.jpa.entity.empresa.EmpresaJpaEntity;

public interface EmpresaRepository extends JpaRepository<EmpresaJpaEntity, Long> {

}
