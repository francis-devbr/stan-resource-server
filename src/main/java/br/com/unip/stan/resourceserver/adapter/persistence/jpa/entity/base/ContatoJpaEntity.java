package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CONTATO")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ContatoJpaEntity extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String tipo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<TelefoneJpaEntity> telefonesJpaEntity;

	@Column(unique = true)
	private String email;
}