package br.com.unip.stan.resourceserver.adapter.web.dto.acesso;

import java.util.Collection;

import br.com.unip.stan.resourceserver.adapter.web.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class UsuarioDTO extends BaseDTO {

    private String username;

    private String password;

    private Collection<RegraDTO> regras;

    private Boolean isSuperUser;

    private boolean isEnable;

}