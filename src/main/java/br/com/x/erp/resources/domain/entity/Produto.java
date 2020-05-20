package br.com.x.erp.resources.domain.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Produto  extends Base{
	
	private String nome;

	private Marca marca;

	private String complemento1;

	private String complemento2;

	private String descricaoGondola;

	private String descricaoCupom;
	
	private List<TipoProduto> tiposProduto;
}
