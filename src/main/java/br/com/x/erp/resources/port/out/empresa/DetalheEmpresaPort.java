package br.com.x.erp.resources.port.out.empresa;

import java.util.List;

import br.com.x.erp.resources.domain.entity.Empresa;

public interface DetalheEmpresaPort {

    List<Empresa> buscarEmpresas();

}
