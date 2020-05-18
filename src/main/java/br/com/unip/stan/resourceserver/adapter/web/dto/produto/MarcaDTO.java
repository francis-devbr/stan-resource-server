package br.com.unip.stan.resourceserver.adapter.web.dto.produto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MarcaDTO {

	private Long id;
	private String nome;

}
