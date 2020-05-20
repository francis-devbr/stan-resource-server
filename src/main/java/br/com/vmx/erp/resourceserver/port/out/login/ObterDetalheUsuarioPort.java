package br.com.vmx.erp.resourceserver.port.out.login;

import java.util.List;

import br.com.vmx.erp.resourceserver.domain.entity.Usuario;

public interface ObterDetalheUsuarioPort {

	Usuario obter(String username);

	List<Usuario> buscarTodos();


}
