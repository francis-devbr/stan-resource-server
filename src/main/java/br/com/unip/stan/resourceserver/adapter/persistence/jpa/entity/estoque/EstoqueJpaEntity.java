package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.estoque;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ESTOQUE")
@Getter
@Setter
public class EstoqueJpaEntity {

	@OneToMany
	List<ProdutoJpaEntity> produtosJpaEntity;

	private BigDecimal quantidade;
	
	
}
