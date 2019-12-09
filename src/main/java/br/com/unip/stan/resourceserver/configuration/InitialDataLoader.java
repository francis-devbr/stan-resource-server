package br.com.unip.stan.resourceserver.configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Privilegio;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Usuario;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Cargo;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Cliente;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Empresa;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Funcionario;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.Endereco;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.Motorista;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Categoria;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Marca;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.TipoCombustivel;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Veiculo;
import br.com.unip.stan.resourceserver.port.in.empresa.CriarCargoService;
import br.com.unip.stan.resourceserver.port.in.empresa.CriarClienteService;
import br.com.unip.stan.resourceserver.port.in.empresa.CriarEmpresaService;
import br.com.unip.stan.resourceserver.port.in.empresa.CriarFuncionarioService;
import br.com.unip.stan.resourceserver.port.in.empresa.ObterDetalheEmpresaService;
import br.com.unip.stan.resourceserver.port.in.localizacao.CriarEnderecoService;
import br.com.unip.stan.resourceserver.port.in.login.CriarPrivilegeService;
import br.com.unip.stan.resourceserver.port.in.login.CriarRoleService;
import br.com.unip.stan.resourceserver.port.in.login.CriarUsuarioService;
import br.com.unip.stan.resourceserver.port.in.motorista.CriarMotoristaService;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarCategoriaService;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarMarcaService;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarTipoCombustivelService;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarVeiculoService;
import br.com.unip.stan.resourceserver.port.in.veiculo.ObterDetalheCategoriaService;
import br.com.unip.stan.resourceserver.port.in.veiculo.ObterDetalheMarcaService;
import br.com.unip.stan.resourceserver.port.in.veiculo.ObterDetalheTipoCombustivelService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private static final String CNPJ_PRINCIPAL = "72907711000155";

	private static final String CNPJ_CLIENTE = "40432544082950";

	boolean alreadySetup = false;

	private final CriarUsuarioService criarUsuarioService;

	private final CriarRoleService criarRoleService;

	private final CriarPrivilegeService criarPrivilegeService;

	private final PasswordEncoder passwordEncoder;

	private final CriarMarcaService criarMarcaService;
	private final CriarTipoCombustivelService criarTipoCombustivelService;
	private final CriarCategoriaService criarCategoriaService;
	private final CriarVeiculoService criarVeiculoService;

	private final CriarEmpresaService criarEmpresaService;
	private final CriarFuncionarioService criarFuncionarioService;
	private final CriarMotoristaService criarMotoristaService;

	private final CriarCargoService criarCargoService;

	private final CriarClienteService criarClienteService;

	private final ObterDetalheEmpresaService obterDetalheEmpresaService;

	private final CriarEnderecoService criarEnderecoService;
	
	private final ObterDetalheCategoriaService obterDetalheCategoriaService;
	private final ObterDetalheMarcaService obterDetalheMarcaService;

	private final ObterDetalheTipoCombustivelService obterDetalheTipoCombustivelService;
	

	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
			return;

		initPrivilegesAndRoles();

		createBase();
		
		createEmpresa();

		createCliente();

		createFuncionarioSupervisor();

		createFuncionarioAtendente();

		createFuncionarioTecnico();

		createMotorista();

		createVeiculo();

		alreadySetup = true;
	}

	private void initPrivilegesAndRoles() {

		// == create initial privileges
		Privilegio readPrivilege = criarPrivilegeService.createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilegio writePrivilege = criarPrivilegeService.createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		Privilegio masterPrivilege = criarPrivilegeService.createPrivilegeIfNotFound("MASTER_PRIVILEGE");

		// == create initial roles
		List<Privilegio> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		criarRoleService.createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);

		List<Privilegio> userPrivileges = Arrays.asList(readPrivilege);
		criarRoleService.createRoleIfNotFound("ROLE_USER", userPrivileges);

		List<Privilegio> guestPrivileges = Arrays.asList(readPrivilege);
		criarRoleService.createRoleIfNotFound("ROLE_GUEST", guestPrivileges);

		List<Privilegio> masterPrivileges = Arrays.asList(masterPrivilege);
		criarRoleService.createRoleIfNotFound("ROLE_MASTER", masterPrivileges);

	}

	private void createBase() {
		Marca marca = Marca.builder().nome("Ford").isEnable(true).build();
		criarMarcaService.criar(marca);

		marca = Marca.builder().nome("Volkswagen").isEnable(true).build();
		criarMarcaService.criar(marca);

		marca = Marca.builder().nome("Fiat").isEnable(true).build();
		marca = criarMarcaService.criar(marca);

		TipoCombustivel tipoCombustivel = TipoCombustivel.builder().nome("Etanol").isEnable(true).build();
		criarTipoCombustivelService.criar(tipoCombustivel);

		tipoCombustivel = TipoCombustivel.builder().nome("Alcool").isEnable(true).build();
		criarTipoCombustivelService.criar(tipoCombustivel);

		tipoCombustivel = TipoCombustivel.builder().nome("Diesel").isEnable(true).build();
		criarTipoCombustivelService.criar(tipoCombustivel);

		tipoCombustivel = TipoCombustivel.builder().nome("Gasolina").isEnable(true).build();
		tipoCombustivel = criarTipoCombustivelService.criar(tipoCombustivel);

		Categoria categoria = Categoria.builder().nome("Utilitario").isEnable(true).build();
		criarCategoriaService.criar(categoria);

		categoria = Categoria.builder().nome("Passeio").isEnable(true).build();
		categoria = criarCategoriaService.criar(categoria);

	}
	
	private void createVeiculo() {

		Empresa empresa = obterDetalheEmpresaService.findByCnpj(CNPJ_CLIENTE);

		List<Categoria> categorias = obterDetalheCategoriaService.obterTodos();
		List<Marca> marcas = obterDetalheMarcaService.obterTodos();
		List<TipoCombustivel> combustiveis = obterDetalheTipoCombustivelService.obterTodos();
		

		Veiculo veiculo = Veiculo.builder()
				.nome("Uno fire")
				.placa("XPT4122")
				.chassi("fsgafsgasfg")
				.renavam("sasasasasasas")
				.marca(marcas.get(2))
				.anoFabricacao(2018)
				.anoModelo(2018)
				.cor("branco")
				.tipoCombustivel(combustiveis.get(0))
				.categoria(categorias.get(1))
				.valorPago(BigDecimal.valueOf(30000))
				.kmInicial(BigDecimal.ZERO)
				.kmAtual(BigDecimal.TEN)
				.mesIpva(1)
				.empresa(empresa)
				.isEnable(true)
				.build();
		
		criarVeiculoService.criar(veiculo);
		
		veiculo = Veiculo.builder()
				.nome("Palio")
				.placa("WWW4122")
				.chassi("asdfgh")
				.renavam("qwertt")
				.marca(marcas.get(2))
				.anoFabricacao(2017)
				.anoModelo(2018)
				.cor("vermelho")
				.tipoCombustivel(combustiveis.get(0))
				.categoria(categorias.get(1))
				.valorPago(BigDecimal.valueOf(20000))
				.kmInicial(BigDecimal.ZERO)
				.kmAtual(BigDecimal.TEN)
				.mesIpva(1)
				.empresa(empresa)
				.isEnable(true)
				.build();
		
		criarVeiculoService.criar(veiculo);

		veiculo = Veiculo.builder()
				.nome("Gol")
				.placa("NYX4122")
				.chassi("ertyuiopop")
				.renavam("uiouiouo")
				.marca(marcas.get(1))
				.anoFabricacao(2016)
				.anoModelo(2017)
				.cor("vermelho")
				.tipoCombustivel(combustiveis.get(0))
				.categoria(categorias.get(1))
				.valorPago(BigDecimal.valueOf(30000))
				.kmInicial(BigDecimal.ZERO)
				.kmAtual(BigDecimal.TEN)
				.mesIpva(1)
				.empresa(empresa)
				.isEnable(true)
				.build();
		criarVeiculoService.criar(veiculo);
	}

	private void createEmpresa() {

		Endereco endereco = Endereco.builder()
				.logradouro("Avenida Principal")
				.cep("06663055").bairro("centro").cidade("Sao Paulo").estado("UF")
				.numero("201").build();

		endereco = criarEnderecoService.criar(endereco);



		Empresa empresa = Empresa.builder().nome("RGB Locações de Automóveis").endereco(endereco).tipoPessoa("J")
				.cpfOuCnpj(CNPJ_PRINCIPAL).inscricaoEstadual("775085384078").telefone("36548989")
				.email("sac@rgb.com").isPrincipal(true).isEnable(true).build();
		criarEmpresaService.criar(empresa);

	}

	private void createCliente() {

		Endereco endereco = Endereco.builder()
				.logradouro("Avenida Principal")
				.cep("06663055").bairro("centro").cidade("Sao Paulo").estado("UF")
				.numero("171").build();
		endereco = criarEnderecoService.criar(endereco);


		Empresa empresa = Empresa.builder().nome("CLARO S.A.").endereco(endereco).tipoPessoa("J")
				.cpfOuCnpj(CNPJ_CLIENTE).telefone("86548989").email("ltorres@claro.com.br")
				.isPrincipal(false).isEnable(true).build();
		empresa = criarEmpresaService.criar(empresa);

		Cliente cliente = Cliente.builder().empresa(empresa).isEnable(true).build();

		criarClienteService.criar(cliente);

	}

	private void createMotorista() {

		Empresa empresa = obterDetalheEmpresaService.findByCnpj(CNPJ_CLIENTE);

		Endereco endereco = Endereco.builder()
				.logradouro("Avenida Principal")
				.cep("06663055").bairro("centro").cidade("Sao Paulo").estado("UF")
				.numero("1800").build();
		endereco = criarEnderecoService.criar(endereco);

		
		Cargo cargo = criarCargoService.createCargoIfNotFound("Motorista");

		Usuario usuario = Usuario.builder().username("rogerio.silva").password(passwordEncoder.encode("123456"))
				.isSuperUser(false).isEnable(true).build();

		usuario = criarUsuarioService.createUserIfNotFound(usuario, "ROLE_GUEST");

		Funcionario funcionario = Funcionario.builder().nome("Rogerio Silva").tipoPessoa("F").cpfOuCnpj("06160044001")
				.endereco(endereco).sexo("M").telefone("54678987").email("rogerio.silva@outlook.com").empresa(empresa)
				.cargo(cargo).usuario(usuario).isEnable(true).build();

		funcionario = criarFuncionarioService.criar(funcionario);

		Motorista motorista = Motorista.builder().funcionario(funcionario).categoria("A").numero("77378246452")
				.renovaEm(LocalDate.parse("2019-01-01")).isEnable(true).build();

		criarMotoristaService.criar(motorista);

	}

	private void createFuncionarioSupervisor() {

		Empresa empresa = obterDetalheEmpresaService.findByCnpj(CNPJ_CLIENTE);

		Endereco endereco = Endereco.builder()
				.logradouro("Avenida Principal")
				.cep("06663055").bairro("centro").cidade("Sao Paulo").estado("UF")
				.numero("400").build();

		endereco = criarEnderecoService.criar(endereco);


		Cargo cargo = criarCargoService.createCargoIfNotFound("Supervisor");

		Usuario usuario = Usuario.builder().username("francis.oliveira").password(passwordEncoder.encode("123456"))
				.isSuperUser(false).isEnable(true).build();

		usuario = criarUsuarioService.createUserIfNotFound(usuario, "ROLE_MASTER");

		Funcionario funcionario = Funcionario.builder().nome("Francis Oliveira").tipoPessoa("F")
				.cpfOuCnpj("31406826898").endereco(endereco).sexo("M").telefone("34567899")
				.email("fnolivei@outlook.com").empresa(empresa).cargo(cargo).usuario(usuario).isEnable(true).build();

		criarFuncionarioService.criar(funcionario);

	}

	private void createFuncionarioTecnico() {


		Empresa empresa = obterDetalheEmpresaService.findByCnpj(CNPJ_CLIENTE);

		Endereco endereco = Endereco.builder()
				.logradouro("Avenida Principal")
				.cep("06663055").bairro("centro").cidade("Sao Paulo").estado("UF")
				.numero("1500").build();

		endereco = criarEnderecoService.criar(endereco);


		Cargo cargo = criarCargoService.createCargoIfNotFound("Tecnico");

		Usuario usuario = Usuario.builder().username("guilherme.serrano").password(passwordEncoder.encode("123456"))
				.isSuperUser(false).isEnable(true).build();

		usuario = criarUsuarioService.createUserIfNotFound(usuario, "ROLE_USER");

		Funcionario funcionario = Funcionario.builder().nome("Guilherme Serrano").tipoPessoa("F")
				.cpfOuCnpj("06130044001").endereco(endereco).sexo("M").telefone("65657878")
				.email("guilherme.serrano@outlook.com").empresa(empresa).cargo(cargo).usuario(usuario).isEnable(true)
				.build();

		criarFuncionarioService.criar(funcionario);

	}

	private void createFuncionarioAtendente() {

		Empresa empresa = obterDetalheEmpresaService.findByCnpj(CNPJ_CLIENTE);

		Endereco endereco = Endereco.builder()
				.logradouro("Avenida Principal")
				.cep("06663055").bairro("centro").cidade("Sao Paulo").estado("UF")
				.numero("800").build();

		endereco = criarEnderecoService.criar(endereco);

		Cargo cargo = criarCargoService.createCargoIfNotFound("Atendente");

		Usuario usuario = Usuario.builder().username("rafaela.silva").password(passwordEncoder.encode("123456"))
				.isSuperUser(false).isEnable(true).build();

		usuario = criarUsuarioService.createUserIfNotFound(usuario, "ROLE_USER");

		Funcionario funcionario = Funcionario.builder().nome("Rafaela Silva").tipoPessoa("F").cpfOuCnpj("21175305839")
				.endereco(endereco).telefone("34211234").email("rafaela.silva@outlook.com").sexo("F").empresa(empresa)
				.cargo(cargo).usuario(usuario).isEnable(true).build();

		criarFuncionarioService.criar(funcionario);

	}

	public void createUsuarioIfNotFound(String username, String password, String regra) {

		Usuario usuario = Usuario.builder().username(username).password(passwordEncoder.encode(password))
				.isSuperUser(false).isEnable(true).build();
		criarUsuarioService.createUserIfNotFound(usuario, regra);

	}

}
