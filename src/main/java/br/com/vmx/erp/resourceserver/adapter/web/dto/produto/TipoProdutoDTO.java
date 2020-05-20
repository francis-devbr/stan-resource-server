package br.com.vmx.erp.resourceserver.adapter.web.dto.produto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TipoProdutoDTO {

	private long id;
	private String nome;

}
