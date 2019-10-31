package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo;

import java.math.BigDecimal;
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
@Table(name = "VEICULO")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class VeiculoJpaEntity extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String placa;

	@NotNull
	private String chassi;

	@NotNull
	private String renavam;

	@NotNull
	@ManyToOne
	private MarcaJpaEntity marcaJpaEntity;

	@NotNull
	private Integer anoFabricacao;

	@NotNull
	private Integer anoModelo;

	@NotNull
	private String cor;

	@NotNull
	@ManyToOne
	private TipoCombustivelJpaEntity tipoCombustivelJpaEntity;

	@NotNull
	@ManyToOne
	private CategoriaJpaEntity categoriaJpaEntity;

	@NotNull
	private BigDecimal valorPago;

	@NotNull
	private BigDecimal kmInicial;

	@NotNull
	private BigDecimal kmAtual;
	
	private LocalDate pneuTrocadoEm;

	@NotNull
	private Integer mesIpva;

	@NotNull
	private boolean isEnable;
}
