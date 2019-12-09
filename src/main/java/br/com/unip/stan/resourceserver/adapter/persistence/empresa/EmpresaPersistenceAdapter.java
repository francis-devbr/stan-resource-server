package br.com.unip.stan.resourceserver.adapter.persistence.empresa;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Empresa;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.empresa.EmpresaRepository;
import br.com.unip.stan.resourceserver.port.out.empresa.ObterDetalheEmpresaPort;
import br.com.unip.stan.resourceserver.port.out.empresa.UpdateEmpresaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmpresaPersistenceAdapter implements UpdateEmpresaPort, ObterDetalheEmpresaPort {

	private final EmpresaRepository empresaRepository;

	@Override
	public Empresa salvar(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@Override
	public Empresa findByCnpj(String cnpj) {
		return empresaRepository.findByCpfOuCnpj(cnpj).orElse(null);
	}

	@Override
	public List<Empresa> buscarTodos() {
		return empresaRepository.findAll();

	}

}
