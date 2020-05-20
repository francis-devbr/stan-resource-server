package br.com.x.erp.resources.adapter.persistence.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.x.erp.resources.adapter.mapper.EmpresaMapper;
import br.com.x.erp.resources.adapter.persistence.jpa.repository.empresa.EmpresaRepository;
import br.com.x.erp.resources.domain.entity.Empresa;
import br.com.x.erp.resources.port.out.empresa.DetalheEmpresaPort;

@Component
public class EmpresaPersistenceAdapter implements DetalheEmpresaPort {

    @Autowired
    private EmpresaRepository empresaRepository;
    
    @Override
    public List<Empresa> buscarEmpresas() {
	return EmpresaMapper.mapToDomainEntity(empresaRepository.findAll());
    }
    
}
