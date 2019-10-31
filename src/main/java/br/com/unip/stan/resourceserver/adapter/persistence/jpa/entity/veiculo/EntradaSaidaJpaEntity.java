package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntityAudit;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.convenio.ConvenioJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.MotoristaJpaEntity;
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
public class EntradaSaidaJpaEntity extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private MotoristaJpaEntity motoristaJpaEntity;

	@ManyToOne
	private VeiculoJpaEntity veiculoJpaEntity;

	@ManyToOne
	private ConvenioJpaEntity convenioJpaEntity;
	
	@NotNull
	private LocalDateTime entradaEm;

	private LocalDateTime saidaEm;
}
