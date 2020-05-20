package br.com.vmx.erp.resourceserver.port.out.empresa;

import java.util.List;

import br.com.vmx.erp.resourceserver.domain.entity.Empresa;

public interface DetalheEmpresaPort {

    List<Empresa> buscarEmpresas();

}
