package br.com.unip.stan.resourceserver.adapter.web.dto.acesso;

import br.com.unip.stan.resourceserver.adapter.web.dto.BaseDTO;
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
public class PrivilegioDTO extends BaseDTO {

	private String nome;

}
