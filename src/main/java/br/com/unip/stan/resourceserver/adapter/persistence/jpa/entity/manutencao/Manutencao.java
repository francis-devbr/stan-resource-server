package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.manutencao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Veiculo;
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
public class Manutencao extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Veiculo veiculo;

	@OneToMany
	private List<ServicoManutencao> servicos;

	private String responsavel;

	private LocalDate inicio;

	private LocalDate fim;

	@ManyToOne
	private TipoManutencao tipoManutencaoJpaEntity;

}
