package br.com.vmx.erp.resourceserver.adapter.web.dto.produto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProdutoDTO {

	private Long id;
	
	private String nome;

	private MarcaDTO marca;

	private String complemento1;

	private String complemento2;

	private String descricaoGondola;

	private String descricaoCupom;
	
	private List<TipoProdutoDTO> tiposProduto;

}
