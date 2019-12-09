package br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.TipoCombustivel;

public interface TipoCombustivelRepository extends JpaRepository<TipoCombustivel, Long> {

}
