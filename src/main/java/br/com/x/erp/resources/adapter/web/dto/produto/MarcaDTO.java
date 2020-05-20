package br.com.x.erp.resources.adapter.web.dto.produto;

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
