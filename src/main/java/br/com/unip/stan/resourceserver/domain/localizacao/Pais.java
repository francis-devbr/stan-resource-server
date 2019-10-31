package br.com.unip.stan.resourceserver.domain.localizacao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Pais {

	private Long id;

	private String nome;

	private String sigla;

}
