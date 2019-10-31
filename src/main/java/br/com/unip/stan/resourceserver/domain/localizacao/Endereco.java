package br.com.unip.stan.resourceserver.domain.localizacao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Endereco {

	private Long id;
	
	private Logradouro logradouro;

	private String numero;

	private String complemento;

}
