package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntityAudit;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "INFRACAO")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class InfracaoJpaEntity extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private VeiculoJpaEntity veiculoJpaEntity;

	@NotNull
	private LocalDate infracaoCometidaEm;

	private String observacao;
}
