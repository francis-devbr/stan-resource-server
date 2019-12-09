package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
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
@Table(name = "RESERVA")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Reserva extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Motorista motorista;

	@NotNull
	private LocalDateTime retiraEm;

	private LocalDateTime entregaEm;

	@OneToOne
	private Funcionario funcionarioJpaEntity;

}
