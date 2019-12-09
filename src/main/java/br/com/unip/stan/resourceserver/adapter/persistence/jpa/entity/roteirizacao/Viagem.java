package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.roteirizacao;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Funcionario;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.Motorista;
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

	@OneToOne
	private Motorista motoristaJpaEntity;
	
	@OneToMany
	private Collection<Funcionario> funcionarios;
	
	@NotNull
	private String origem;
	
	@NotNull
	private String destino;
	
	private LocalDate viagemRealizadaEm;
	
}
