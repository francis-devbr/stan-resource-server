package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Empresa;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ABASTECIMENTO")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Abastecimento extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Veiculo veiculo;
	private String cnpj;
	private BigDecimal litro;
	private BigDecimal valor;
	private String cupom;
	private LocalDate abastecidoEm;
	private BigDecimal km;
	
	
	
}
