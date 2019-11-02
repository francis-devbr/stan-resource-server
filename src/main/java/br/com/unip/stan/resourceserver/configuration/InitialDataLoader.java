package br.com.unip.stan.resourceserver.configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.Contato;
import br.com.unip.stan.resourceserver.domain.Pessoa;
import br.com.unip.stan.resourceserver.domain.Telefone;
import br.com.unip.stan.resourceserver.domain.TipoPessoa;
import br.com.unip.stan.resourceserver.domain.empresa.Cargo;
import br.com.unip.stan.resourceserver.domain.empresa.Empresa;
import br.com.unip.stan.resourceserver.domain.empresa.Funcionario;
import br.com.unip.stan.resourceserver.domain.localizacao.Bairro;
import br.com.unip.stan.resourceserver.domain.localizacao.Cidade;
import br.com.unip.stan.resourceserver.domain.localizacao.Endereco;
import br.com.unip.stan.resourceserver.domain.localizacao.Estado;
import br.com.unip.stan.resourceserver.domain.localizacao.Logradouro;
import br.com.unip.stan.resourceserver.domain.localizacao.Pais;
import br.com.unip.stan.resourceserver.domain.localizacao.TipoLogradouro;
import br.com.unip.stan.resourceserver.domain.login.Privilege;
import br.com.unip.stan.resourceserver.domain.login.Usuario;
import br.com.unip.stan.resourceserver.domain.motorista.Cnh;
import br.com.unip.stan.resourceserver.domain.motorista.Motorista;
import br.com.unip.stan.resourceserver.domain.veiculo.Categoria;
import br.com.unip.stan.resourceserver.domain.veiculo.Marca;
import br.com.unip.stan.resourceserver.domain.veiculo.Modelo;
import br.com.unip.stan.resourceserver.domain.veiculo.TipoCombustivel;
import br.com.unip.stan.resourceserver.domain.veiculo.Veiculo;
import br.com.unip.stan.resourceserver.port.in.ObterDetalhePessoaService;
import br.com.unip.stan.resourceserver.port.in.empresa.CriarCargoService;
import br.com.unip.stan.resourceserver.port.in.empresa.CriarEmpresaService;
import br.com.unip.stan.resourceserver.port.in.empresa.CriarFuncionarioService;
import br.com.unip.stan.resourceserver.port.in.empresa.ObterDetalheEmpresaService;
import br.com.unip.stan.resourceserver.port.in.localizacao.CriarBairroService;
import br.com.unip.stan.resourceserver.port.in.localizacao.CriarCidadeService;
import br.com.unip.stan.resourceserver.port.in.localizacao.CriarEstadoService;
import br.com.unip.stan.resourceserver.port.in.localizacao.CriarLogradouroService;
import br.com.unip.stan.resourceserver.port.in.localizacao.CriarPaisService;
import br.com.unip.stan.resourceserver.port.in.localizacao.CriarTipoLogradouroService;
import br.com.unip.stan.resourceserver.port.in.localizacao.ObterDetalheEstadoService;
import br.com.unip.stan.resourceserver.port.in.localizacao.ObterDetalheLogradouroService;
import br.com.unip.stan.resourceserver.port.in.localizacao.ObterDetalhePaisService;
import br.com.unip.stan.resourceserver.port.in.localizacao.ObterDetalheTipoLogradouroService;
import br.com.unip.stan.resourceserver.port.in.login.CriarPrivilegeService;
import br.com.unip.stan.resourceserver.port.in.login.CriarRoleService;
import br.com.unip.stan.resourceserver.port.in.login.CriarUsuarioService;
import br.com.unip.stan.resourceserver.port.in.motorista.CriarMotoristaService;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarCategoriaService;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarMarcaService;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarModeloService;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarTipoCombustivelService;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarVeiculoService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	private final ObterDetalhePessoaService obterDetalhePessoaService;
	
	private final CriarUsuarioService criarUsuarioService;

	private final CriarRoleService criarRoleService;

	private final CriarPrivilegeService criarPrivilegeService;

	private final CriarPaisService criarPaisService;
	
	private final CriarEstadoService criarEstadoService;

	private final CriarCidadeService criarCidadeService;

	private final CriarBairroService criarBairroService;

	private final CriarTipoLogradouroService criarTipoLogradouroService;
	
	private final CriarLogradouroService criarLogradouroService;
	
	private final ObterDetalhePaisService obterDetalhePaisService;
	
	private final ObterDetalheTipoLogradouroService obterDetalheTipoLogradouroService;
	
	private final ObterDetalheEstadoService obterDetalheEstadoService;

	private final ObterDetalheLogradouroService obterDetalheLogradouroService;
	
	private final PasswordEncoder passwordEncoder;
	
	private final CriarModeloService criarModeloService;
	private final CriarMarcaService criarMarcaService;
	private final CriarTipoCombustivelService criarTipoCombustivelService;
	private final CriarCategoriaService criarCategoriaService;
	private final CriarVeiculoService criarVeiculoService;
	
	private final CriarEmpresaService criarEmpresaService;
	private final CriarFuncionarioService criarFuncionarioService;
	private final CriarMotoristaService criarMotoristaService;
	
	private final CriarCargoService criarCargoService;
	
	private final ObterDetalheEmpresaService obterDetalheEmpresaService;
	
	
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
			return;

		initPrivilegesAndRoles();

		createUserMaster();
		
		createPaises();

		createUfPaisBr();

		createTipoLogradouro();

		createLogradourosUfSP();

		createEmpresa();

		//createFuncionarioSupervisor();

		//createFuncionarioAtendente();

		//createFuncionarioTecnico();

		//createMotorista();

		//createVeiculo();

		alreadySetup = true;
	}

	private void createUserMaster() {

		
		  Usuario user = Usuario.builder() .username("master")
		  .password(passwordEncoder.encode("123456")) .isEnable(true) .build();
		  
		  criarUsuarioService.createUserIfNotFound(user, "ROLE_MASTER");
		 

	}

	private void initPrivilegesAndRoles() {

		// == create initial privileges
		Privilege readPrivilege = criarPrivilegeService.createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilege writePrivilege = criarPrivilegeService.createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		Privilege masterPrivilege = criarPrivilegeService.createPrivilegeIfNotFound("MASTER_PRIVILEGE");

		// == create initial roles
		List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		criarRoleService.createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);

		List<Privilege> userPrivileges = Arrays.asList(readPrivilege);
		criarRoleService.createRoleIfNotFound("ROLE_USER", userPrivileges);

		List<Privilege> guestPrivileges = Arrays.asList(readPrivilege);
		criarRoleService.createRoleIfNotFound("ROLE_GUEST", guestPrivileges);

		List<Privilege> masterPrivileges = Arrays.asList(masterPrivilege);
		criarRoleService.createRoleIfNotFound("ROLE_MASTER", masterPrivileges);

	}

	private void createPaises() {

		List<Pais> paises = new ArrayList<>();

		Pais pais = Pais.builder().sigla("AD").nome("Andorra").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AE").nome("Emirados Árabes Unidos").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BR").nome("Brasil").build();
		paises.add(pais);


		criarPaisService.criar(paises);
	}
	
	private void createVeiculo() {
		
		Modelo modelo = Modelo.builder()
				.nome("Uno fire")
				.isEnable(true)
				.build();
		modelo = criarModeloService.criar(modelo);

		Marca marca = Marca.builder()
				.nome("Fiat")
				.modelos(Arrays.asList(modelo))
				.isEnable(true)
				.build();
		marca = criarMarcaService.criar(marca);

		TipoCombustivel tipoCombustivel = TipoCombustivel.builder()
				.nome("Gasolina")
				.isEnable(true)
				.build();
		tipoCombustivel = criarTipoCombustivelService.criar(tipoCombustivel);

		Categoria categoria = Categoria.builder()
				.nome("Passeio")
				.isEnable(true)
				.build();
		categoria = criarCategoriaService.criar(categoria);

		
		Veiculo veiculo = Veiculo.builder()
				.placa("XPT4122")
				.chassi("fsgafsgasfg")
				.renavam("sasasasasasas")
				.marca(marca)
				.anoFabricacao(2018)
				.anoModelo(2018)
				.cor("branco")
				.tipoCombustivel(tipoCombustivel)
				.categoria(categoria)
				.valorPago(BigDecimal.valueOf(30000))
				.kmInicial(BigDecimal.ZERO)
				.kmAtual(BigDecimal.TEN)
				.mesIpva(1)
				.isEnable(true)
				.build();

		criarVeiculoService.criar(veiculo);
	}

	private void createTipoLogradouro() {

		List<TipoLogradouro> tiposLogradouro = new ArrayList<>();

		TipoLogradouro tipoLogradouro = TipoLogradouro.builder()
				.nome("Rua")
				.build();
		tiposLogradouro.add(tipoLogradouro);

		tipoLogradouro = TipoLogradouro.builder()
				.nome("Avenida")
				.build();
		tiposLogradouro.add(tipoLogradouro);

		tipoLogradouro = TipoLogradouro.builder()
				.nome("Travessa")
				.build();
		tiposLogradouro.add(tipoLogradouro);

		tipoLogradouro = TipoLogradouro.builder()
				.nome("Passagem")
				.build();
		tiposLogradouro.add(tipoLogradouro);

		tipoLogradouro = TipoLogradouro.builder()
				.nome("Praça")
				.build();
		tiposLogradouro.add(tipoLogradouro);

		criarTipoLogradouroService.criar(tiposLogradouro);
	}

	private void createLogradourosUfSP() {

		List<Cidade> cidades = new ArrayList<>();
		List<Bairro> bairros = new ArrayList<>();
		List<Logradouro> logradouros = new ArrayList<>();

		Estado estado = obterDetalheEstadoService.findBySigla("SP");

		Cidade cidade = Cidade.builder()
				.estado(estado)
				.nome("Sao Paulo")
				.build();
		cidades.add(cidade);

		Bairro bairro = Bairro.builder()
				.cidade(cidade)
				.nome("Bela Vista")
				.build();
		bairros.add(bairro);

		TipoLogradouro tipoLogradouro = obterDetalheTipoLogradouroService.findByNome("Rua");

		Logradouro logradouro = Logradouro.builder()
				.cep("01308040")
				.tipoLogradouro(tipoLogradouro)
				.nome("São Miguel")
				.bairro(bairro)
				.build();
		logradouros.add(logradouro);

		bairro = Bairro.builder()
				.cidade(cidade)
				.nome("Cambuci")
				.build();
		bairros.add(bairro);

		tipoLogradouro = obterDetalheTipoLogradouroService.findByNome("Rua");

		logradouro = Logradouro.builder()
				.cep("01543000")
				.tipoLogradouro(tipoLogradouro)
				.nome("Heitor Peixoto")
				.complemento("- até 429/430")
				.bairro(bairro)
				.build();
		logradouros.add(logradouro);

		cidade = Cidade.builder()
				.estado(estado)
				.nome("Diadema")
				.build();
		cidades.add(cidade);

		bairro = Bairro.builder()
				.cidade(cidade)
				.nome("Eldorado")
				.build();
		bairros.add(bairro);

		tipoLogradouro = obterDetalheTipoLogradouroService.findByNome("Praça");

		logradouro = Logradouro.builder()
				.cep("09971370")
				.tipoLogradouro(tipoLogradouro)
				.nome("Gilberto")
				.complemento("(Pr Vermelha)")
				.bairro(bairro)
				.build();
		logradouros.add(logradouro);

		bairro = Bairro.builder()
				.cidade(cidade)
				.nome("Centro")
				.build();
		bairros.add(bairro);

		tipoLogradouro = obterDetalheTipoLogradouroService.findByNome("Rua");
		logradouro = Logradouro.builder()
				.cep("09910030")
				.tipoLogradouro(tipoLogradouro)
				.nome("Antônio Pedrozelli")
				.complemento("(Prq S Setembro)")
				.bairro(bairro)
				.build();
		logradouros.add(logradouro);

		bairro = Bairro.builder()
				.cidade(cidade)
				.nome("Serraria")
				.build();
		bairros.add(bairro);

		tipoLogradouro = obterDetalheTipoLogradouroService.findByNome("Passagem");
		logradouro = Logradouro.builder()
				.cep("09990104")
				.tipoLogradouro(tipoLogradouro)
				.nome("Mãe Rainha")
				.bairro(bairro)
				.build();
		logradouros.add(logradouro);

		tipoLogradouro = obterDetalheTipoLogradouroService.findByNome("Travessa");
		logradouro = Logradouro.builder()
				.cep("09980243")
				.tipoLogradouro(tipoLogradouro)
				.nome("Antônio Bispo José dos Reis")
				.bairro(bairro)
				.build();
		logradouros.add(logradouro);

		criarCidadeService.criar(cidades);

		criarBairroService.criar(bairros);

		criarLogradouroService.criar(logradouros);
	}

	private void createUfPaisBr() {

		Pais pais = obterDetalhePaisService.findBySigla("BR");

		List<Estado> estados = new ArrayList<>();

		Estado estado = Estado.builder().sigla("AC").nome("Acre").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("AL").nome("Alagoas").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("AM").nome("Amazonas").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("AP").nome("Amapá").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("BA").nome("Bahia").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("CE").nome("Ceará").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("DF").nome("Distrito Federal").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("ES").nome("Espírito Santo").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("GO").nome("Goiás").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("MA").nome("Maranhão").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("MG").nome("Minas Gerais").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("MS").nome("Mato Grosso do Sul").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("MT").nome("Mato Grosso").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("PA").nome("Pará").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("PB").nome("Paraíba").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("PE").nome("Pernambuco").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("PI").nome("Piauí").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("PR").nome("Paraná").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("RJ").nome("Rio de Janeiro").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("RN").nome("Rio Grande do Norte").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("RO").nome("Rondônia").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("RR").nome("Roraima").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("RS").nome("Rio Grande do Sul").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("SC").nome("Santa Catarina").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("SE").nome("Sergipe").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("SP").nome("São Paulo").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("TO").nome("Tocantins").pais(pais).build();
		estados.add(estado);

		criarEstadoService.criar(estados);
	}

	private void createEmpresa() {

		Logradouro logradouro = obterDetalheLogradouroService.findByCep("01308040");

		Endereco endereco = Endereco.builder()
				.logradouro(logradouro)
				.numero("201")
				.build();

		Telefone telefone = Telefone.builder()
				.tipo("Fixo")
				.ddd("11")
				.numero("41414141")
				.isEnable(true)
				.build();

		Contato contato = Contato.builder()
				.tipo("Comercial")
				.telefones(Arrays.asList(telefone))
				.email("sac@rgb.com")
				.build();

		Pessoa pessoa = Pessoa.builder()
				.nome("RGB Locações de Automóveis")
				.tipoPessoa(TipoPessoa.JURIDICA)
				.cpfOuCnpj("72907711000155")
				.enderecos(Arrays.asList(endereco))
				.contatos(Arrays.asList(contato))
				.build();

		Empresa empresa = Empresa.builder()
				.pessoa(pessoa)
				.inscricaoEstadual("775085384078")
				.isEnable(true)
				.build();
		criarEmpresaService.criar(empresa);
		
		
	}

	private void createMotorista() {

		Pessoa pessoa = obterDetalhePessoaService.findByCpfOuCnpj("06160044001");

		Cnh cnh = Cnh.builder()
				.categoria("A")
				.numero("77378246452")
				.renovaEm(LocalDate.parse("2019-01-01"))
				.build();

		Motorista motorista = Motorista.builder()
				.pessoa(pessoa)
				.cnh(cnh)
				.isEnable(true)
				.build();

		criarMotoristaService.criar(motorista);

	}

	private void createFuncionarioSupervisor() {

		List<Telefone> telefones = new ArrayList<>();

		Logradouro logradouro = obterDetalheLogradouroService.findByCep("09910030");

		Endereco endereco = Endereco.builder()
				.logradouro(logradouro)
				.numero("400")
				.build();

		Telefone telefone = Telefone.builder()
				.tipo("Celular")
				.ddd("11")
				.numero("947020140")
				.isEnable(true)
				.build();
		telefones.add(telefone);

		telefone = Telefone.builder()
				.tipo("Fixo")
				.ddd("11")
				.numero("41414141")
				.isEnable(true)
				.build();
		telefones.add(telefone);

		Contato contato = Contato.builder()
				.tipo("Pessoal")
				.telefones(telefones)
				.email("fnolivei@outlook.com")
				.build();

		Pessoa pessoa = Pessoa.builder()
				.nome("Francis Oliveira")
				.tipoPessoa(TipoPessoa.FISICA)
				.cpfOuCnpj("31406826898")
				.enderecos(Arrays.asList(endereco))
				.contatos(Arrays.asList(contato))
				.build();

		Cargo cargo = criarCargoService.createCargoIfNotFound("Supervisor");

		Empresa empresa = obterDetalheEmpresaService
				.findByPessoa(obterDetalhePessoaService.findByCpfOuCnpj("72907711000155"));

		Funcionario funcionario = Funcionario.builder()
				.pessoa(pessoa)
				.sexo("M")
				.empresa(empresa)
				.cargo(cargo)
				.isEnable(true)
				.build();

		criarFuncionarioService.criar(funcionario);

	}

	private void createFuncionarioTecnico() {

		List<Telefone> telefones = new ArrayList<>();

		Empresa empresa = obterDetalheEmpresaService
				.findByPessoa(obterDetalhePessoaService.findByCpfOuCnpj("72907711000155"));

		Logradouro logradouro = obterDetalheLogradouroService.findByCep("09980243");

		Endereco endereco = Endereco.builder()
				.logradouro(logradouro)
				.numero("1800")
				.build();

		Telefone telefone = Telefone.builder()
				.tipo("Celular")
				.ddd("11")
				.numero("996959630")
				.isEnable(true)
				.build();
		telefones.add(telefone);

		telefone = Telefone.builder()
				.tipo("Fixo")
				.ddd("11")
				.numero("37284341")
				.isEnable(true)
				.build();
		telefones.add(telefone);

		Contato contato = Contato.builder()
				.tipo("Pessoal")
				.telefones(telefones)
				.email("rogerio.silva@outlook.com")
				.build();

		Pessoa pessoa = Pessoa.builder()
				.nome("Rogerio Silva")
				.tipoPessoa(TipoPessoa.FISICA)
				.cpfOuCnpj("06160044001")
				.enderecos(Arrays.asList(endereco))
				.contatos(Arrays.asList(contato))
				.build();

		Cargo cargo = criarCargoService.createCargoIfNotFound("Tecnico");

		Funcionario funcionario = Funcionario.builder()
				.pessoa(pessoa)
				.sexo("M")
				.empresa(empresa)
				.cargo(cargo)
				.isEnable(true)
				.build();

		criarFuncionarioService.criar(funcionario);


	}

	private void createFuncionarioAtendente() {

		List<Telefone> telefones = new ArrayList<>();

		Empresa empresa = obterDetalheEmpresaService
				.findByPessoa(obterDetalhePessoaService.findByCpfOuCnpj("72907711000155"));

		Logradouro logradouro = obterDetalheLogradouroService.findByCep("09980243");

		Endereco endereco = Endereco.builder()
				.logradouro(logradouro)
				.numero("800")
				.build();

		Telefone telefone = Telefone.builder()
				.tipo("Celular")
				.ddd("11")
				.numero("999959630")
				.isEnable(true)
				.build();
		telefones.add(telefone);

		telefone = Telefone.builder()
				.tipo("Fixo")
				.ddd("11")
				.numero("36284141")
				.isEnable(true)
				.build();
		telefones.add(telefone);

		Contato contato = Contato.builder()
				.tipo("Pessoal")
				.telefones(telefones)
				.email("rafaela.silva@outlook.com")
				.build();

		Pessoa pessoa = Pessoa.builder()
				.nome("Rafaela Silva")
				.tipoPessoa(TipoPessoa.FISICA)
				.cpfOuCnpj("21175305839")
				.enderecos(Arrays.asList(endereco))
				.contatos(Arrays.asList(contato))
				.build();

		Cargo cargo = criarCargoService.createCargoIfNotFound("Atendente");

		Funcionario funcionario = Funcionario.builder()
				.pessoa(pessoa)
				.sexo("F")
				.empresa(empresa)
				.cargo(cargo)
				.isEnable(true)
				.build();

		criarFuncionarioService.criar(funcionario);

	}

	
	public void createUsuarioIfNotFound(String username, String password, String regra,
			Pessoa pessoa) {

			Usuario usuario = Usuario.builder()
					.username(username)
					.password(passwordEncoder.encode(password))
					.pessoa(pessoa)
					.isEnable(true)
					.build();
		criarUsuarioService.createUserIfNotFound(usuario, regra);

	}

}
