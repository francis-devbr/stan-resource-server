package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.manutencao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SERVICO_MANUTENCAO")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ServicoManutencao extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private String valor;
	
	@NotNull
	private String responsavel;
	
	@OneToMany
	private List<MaterialManutencao> materiais;
	
}
