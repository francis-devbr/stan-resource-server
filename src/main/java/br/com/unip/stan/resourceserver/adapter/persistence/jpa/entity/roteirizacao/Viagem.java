package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.roteirizacao;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.Endereco;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.Motorista;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Veiculo;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VIAGEM")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Viagem extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Motorista motorista;
	

	@ManyToOne
	private Veiculo veiculo;
	
	@ManyToOne
	private Endereco origem;
	
	@ManyToOne
	private Endereco destino;
	
	private LocalDate viagemRealizadaEm;
	
}
