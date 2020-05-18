package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.EmpresaJpaEntity;

public interface EmpresaRepository extends JpaRepository<EmpresaJpaEntity, Long> {

    
    @Query(value = "SELECT p FROM EmpresaJpaEntity p WHERE p.nome= :nome")
    EmpresaJpaEntity buscarPorNome(@Param("nome") String name );
    
}
