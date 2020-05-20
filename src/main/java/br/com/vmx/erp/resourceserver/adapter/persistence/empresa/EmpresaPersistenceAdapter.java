package br.com.vmx.erp.resourceserver.adapter.persistence.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.vmx.erp.resourceserver.adapter.mapper.EmpresaMapper;
import br.com.vmx.erp.resourceserver.adapter.persistence.jpa.repository.empresa.EmpresaRepository;
import br.com.vmx.erp.resourceserver.domain.entity.Empresa;
import br.com.vmx.erp.resourceserver.port.out.empresa.DetalheEmpresaPort;

@Component
public class EmpresaPersistenceAdapter implements DetalheEmpresaPort {

    @Autowired
    private EmpresaRepository empresaRepository;
    
    @Override
    public List<Empresa> buscarEmpresas() {
	return EmpresaMapper.mapToDomainEntity(empresaRepository.findAll());
    }
    
}
