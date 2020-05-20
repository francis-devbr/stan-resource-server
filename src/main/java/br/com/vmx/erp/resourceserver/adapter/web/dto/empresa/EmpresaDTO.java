package br.com.vmx.erp.resourceserver.adapter.web.dto.empresa;

import br.com.vmx.erp.resourceserver.adapter.web.dto.BaseDTO;
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
public class EmpresaDTO extends BaseDTO {
    private String nome;
}