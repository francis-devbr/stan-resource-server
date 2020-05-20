package br.com.x.erp.resources.adapter.persistence.jpa.entity.produto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.x.erp.resources.adapter.persistence.jpa.entity.base.BaseJpaEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUTO")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ProdutoJpaEntity extends BaseJpaEntity {

	private static final long serialVersionUID = 1L;

	private String nome;

	private MarcaJpaEntity marca;

	private String complemento1;

	private String complemento2;

	private String descricaoGondola;

	private String descricaoCupom;

	@OneToMany
	private List<TipoProdutoJpaEntity> tiposProduto;
}
