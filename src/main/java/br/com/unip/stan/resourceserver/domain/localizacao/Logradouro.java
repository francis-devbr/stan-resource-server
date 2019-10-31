package br.com.unip.stan.resourceserver.domain.localizacao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Logradouro {

	private Long id;

	private String cep;

	private String nome;

	private TipoLogradouro tipoLogradouro;

	private String complemento;

	private String local;

	private Bairro bairro;
}
