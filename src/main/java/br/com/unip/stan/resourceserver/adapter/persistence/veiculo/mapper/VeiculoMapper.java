package br.com.unip.stan.resourceserver.adapter.persistence.veiculo.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.VeiculoJpaEntity;
import br.com.unip.stan.resourceserver.domain.veiculo.Veiculo;

public class VeiculoMapper {

	public static Optional<Veiculo> maptToDomainEntity(Optional<VeiculoJpaEntity> veiculoJpaEntity) {

		Optional<Veiculo> veiculo = Optional.empty();

		if (veiculoJpaEntity.isPresent()) {
			veiculo = Optional.of(maptToDomainEntity(veiculoJpaEntity.get()));
		}

		return veiculo;
	}

	public static List<Veiculo> maptToDomainEntity(Collection<VeiculoJpaEntity> veiculosJpaEntity) {
		return veiculosJpaEntity.stream().map(VeiculoMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<VeiculoJpaEntity> maptToJpaEntity(Collection<Veiculo> veiculos) {
		return veiculos.stream().map(VeiculoMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Veiculo maptToDomainEntity(VeiculoJpaEntity veiculoJpaEntity) {
		return Veiculo.builder()
				.id(veiculoJpaEntity.getId())
				.placa(veiculoJpaEntity.getPlaca())
				.chassi(veiculoJpaEntity.getChassi())
				.renavam(veiculoJpaEntity.getRenavam())
				.marca(MarcaMapper.maptToDomainEntity(veiculoJpaEntity.getMarcaJpaEntity()))
				.anoFabricacao(veiculoJpaEntity.getAnoFabricacao())
				.anoModelo(veiculoJpaEntity.getAnoModelo())
				.cor(veiculoJpaEntity.getCor())
				.tipoCombustivel(TipoCombustivelMapper.maptToDomainEntity(veiculoJpaEntity.getTipoCombustivelJpaEntity()))
				.categoria(CategoriaMapper.maptToDomainEntity(veiculoJpaEntity.getCategoriaJpaEntity()))
				.valorPago(veiculoJpaEntity.getValorPago())
				.kmInicial(veiculoJpaEntity.getKmInicial())
				.kmAtual(veiculoJpaEntity.getKmAtual())
				.pneuTrocadoEm(veiculoJpaEntity.getPneuTrocadoEm())
				.mesIpva(veiculoJpaEntity.getMesIpva())
				.isEnable(veiculoJpaEntity.isEnable())
				.build();
	}

	public static VeiculoJpaEntity maptToJpaEntity(Veiculo veiculo) {
		
		return VeiculoJpaEntity.builder()
				.id(veiculo.getId())
				.placa(veiculo.getPlaca())
				.chassi(veiculo.getChassi())
				.renavam(veiculo.getRenavam())
				.marcaJpaEntity(MarcaMapper.maptToJpaEntity(veiculo.getMarca()))
				.anoFabricacao(veiculo.getAnoFabricacao())
				.anoModelo(veiculo.getAnoModelo())
				.cor(veiculo.getCor())
				.tipoCombustivelJpaEntity(TipoCombustivelMapper.maptToJpaEntity(veiculo.getTipoCombustivel()))
				.categoriaJpaEntity(CategoriaMapper.maptToJpaEntity(veiculo.getCategoria()))
				.valorPago(veiculo.getValorPago())
				.kmInicial(veiculo.getKmInicial())
				.kmAtual(veiculo.getKmAtual())
				.pneuTrocadoEm(veiculo.getPneuTrocadoEm())
				.mesIpva(veiculo.getMesIpva())
				.isEnable(veiculo.isEnable())
				.version(0L)
				.build();
	}

}
