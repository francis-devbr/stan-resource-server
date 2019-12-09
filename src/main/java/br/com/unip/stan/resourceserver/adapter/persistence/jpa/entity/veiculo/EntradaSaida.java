package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.convenio.Convenio;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.Motorista;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ENTRADA_SAIDA")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class EntradaSaida extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Motorista motorista;

	@ManyToOne
	private Veiculo veiculo;

	@ManyToOne
	private Convenio convenio;
	
	@NotNull
	private LocalDateTime entradaEm;

	private LocalDateTime saidaEm;
}
