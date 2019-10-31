package br.com.unip.stan.resourceserver.domain.localizacao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Estado  {

	private Long id;

	private String sigla;

	private String nome;

	private Pais pais;

}
