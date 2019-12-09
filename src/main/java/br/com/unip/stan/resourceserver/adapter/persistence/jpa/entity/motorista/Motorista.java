package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Funcionario;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MOTORISTA")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Motorista extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Funcionario funcionario;

	private String numero;

	private LocalDate renovaEm;

	private String categoria;

	private boolean isEnable;

}
