package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REGRA")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class RegraJpaEntity extends BaseJpaEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String nome;

	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "regras_privilegios", 
	joinColumns = @JoinColumn(name = "regra_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "privilegio_id", referencedColumnName = "id"))
	private Collection<PrivilegioJpaEntity> privilegios;

}
