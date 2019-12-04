package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.VeiculoJpaEntity;

public interface VeiculoRepository extends JpaRepository<VeiculoJpaEntity, Long> {

}
