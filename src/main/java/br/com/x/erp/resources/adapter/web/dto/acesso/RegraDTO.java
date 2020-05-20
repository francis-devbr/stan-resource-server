package br.com.x.erp.resources.adapter.web.dto.acesso;

import java.util.Collection;

import br.com.x.erp.resources.adapter.web.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class RegraDTO extends BaseDTO {

	private String nome;

	private Collection<PrivilegioDTO> privilegios;

}
