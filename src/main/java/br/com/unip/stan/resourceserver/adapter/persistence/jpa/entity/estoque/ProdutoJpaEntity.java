package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.estoque;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUTO")
@Getter
@Setter
public class ProdutoJpaEntity {

	private String nome;
	
	private String descricao;
	
}
