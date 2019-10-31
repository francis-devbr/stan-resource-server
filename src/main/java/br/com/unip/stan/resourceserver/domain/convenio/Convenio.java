package br.com.unip.stan.resourceserver.domain.convenio;

import br.com.unip.stan.resourceserver.domain.empresa.Empresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Convenio {
	
	private Long id;
	
	private Empresa empresa;

	private String nome;

	private String tipoConvenio;

	private boolean isEnable;

}
