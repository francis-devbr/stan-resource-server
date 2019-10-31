package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.manutencao;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntityAudit;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.VeiculoJpaEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MANUTENCAO")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ManutencaoJpaEntity extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private VeiculoJpaEntity veiculoJpaEntity;

	private LocalDate inicio;

	private LocalDate fim;

	@ManyToOne
	private TipoManutencaoJpaEntity tipoManutencaoJpaEntity;

}
