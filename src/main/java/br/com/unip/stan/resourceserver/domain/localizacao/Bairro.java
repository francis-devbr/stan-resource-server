package br.com.unip.stan.resourceserver.domain.localizacao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Bairro {

	private Long id;
	
	private String nome;

	private Cidade cidade;

}
