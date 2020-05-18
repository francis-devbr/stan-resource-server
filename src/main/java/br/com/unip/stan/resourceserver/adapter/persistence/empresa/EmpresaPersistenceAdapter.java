package br.com.unip.stan.resourceserver.adapter.persistence.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.mapper.EmpresaMapper;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.empresa.EmpresaRepository;
import br.com.unip.stan.resourceserver.domain.entity.Empresa;
import br.com.unip.stan.resourceserver.port.out.empresa.DetalheEmpresaPort;

@Component
public class EmpresaPersistenceAdapter implements DetalheEmpresaPort {

    @Autowired
    private EmpresaRepository empresaRepository;
    
    @Override
    public List<Empresa> buscarEmpresas() {
	return EmpresaMapper.mapToDomainEntity(empresaRepository.findAll());
    }
    
}
