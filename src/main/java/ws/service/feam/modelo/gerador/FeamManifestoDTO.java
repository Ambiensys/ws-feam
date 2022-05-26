package ws.service.feam.modelo.gerador;

import java.io.Serializable;
import java.util.List;

public class FeamManifestoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String  cnpDestinador;
	private Integer codUnidadeDestinador;
	private String  cnpTransportador;
	private Integer codUnidadeTransportador;
	private String  cnpArmazenador;
	private Integer codUnidadeArmazenador;
	private Integer seuCodigoReferencia;
	private String  manifObservacao;
	private String  manifGeradorNomeResponsavel;
	private String  manifGeradorCargoResponsavel;
	private String  manifTransportadorNomeMotorista;
	private String  manifTransportadorPlacaVeiculo;
	private String  manifTransportadorDataExpedicao;
	private List<FeamItemManifesto> itemManifestoJSONs;

	public String getCnpTransportador() {
		return cnpTransportador;
	}

	public void setCnpTransportador(String cnpTransportador) {
		this.cnpTransportador = cnpTransportador;
	}

	public Integer getCodUnidadeTransportador() {
		return codUnidadeTransportador;
	}

	public void setCodUnidadeTransportador(Integer codUnidadeTransportador) {
		this.codUnidadeTransportador = codUnidadeTransportador;
	}

	public String getCnpArmazenador() {
		return cnpArmazenador;
	}

	public void setCnpArmazenador(String cnpArmazenador) {
		this.cnpArmazenador = cnpArmazenador;
	}

	public Integer getCodUnidadeArmazenador() {
		return codUnidadeArmazenador;
	}

	public void setCodUnidadeArmazenador(Integer codUnidadeArmazenador) {
		this.codUnidadeArmazenador = codUnidadeArmazenador;
	}

	public Integer getSeuCodigoReferencia() {
		return seuCodigoReferencia;
	}

	public void setSeuCodigoReferencia(Integer seuCodigoReferencia) {
		this.seuCodigoReferencia = seuCodigoReferencia;
	}

	public String getManifObservacao() {
		return manifObservacao;
	}

	public void setManifObservacao(String manifObservacao) {
		this.manifObservacao = manifObservacao;
	}

	public String getManifGeradorNomeResponsavel() {
		return manifGeradorNomeResponsavel;
	}

	public void setManifGeradorNomeResponsavel(String manifGeradorNomeResponsavel) {
		this.manifGeradorNomeResponsavel = manifGeradorNomeResponsavel;
	}

	public String getManifGeradorCargoResponsavel() {
		return manifGeradorCargoResponsavel;
	}

	public void setManifGeradorCargoResponsavel(String manifGeradorCargoResponsavel) {
		this.manifGeradorCargoResponsavel = manifGeradorCargoResponsavel;
	}

	public String getManifTransportadorNomeMotorista() {
		return manifTransportadorNomeMotorista;
	}

	public void setManifTransportadorNomeMotorista(String manifTransportadorNomeMotorista) {
		this.manifTransportadorNomeMotorista = manifTransportadorNomeMotorista;
	}

	public String getManifTransportadorPlacaVeiculo() {
		return manifTransportadorPlacaVeiculo;
	}

	public void setManifTransportadorPlacaVeiculo(String manifTransportadorPlacaVeiculo) {
		this.manifTransportadorPlacaVeiculo = manifTransportadorPlacaVeiculo;
	}

	public String getManifTransportadorDataExpedicao() {
		return manifTransportadorDataExpedicao;
	}

	public void setManifTransportadorDataExpedicao(String manifTransportadorDataExpedicao) {
		this.manifTransportadorDataExpedicao = manifTransportadorDataExpedicao;
	}

	public List<FeamItemManifesto> getItemManifestoJSONs() {
		return itemManifestoJSONs;
	}

	public void setItemManifestoJSONs(List<FeamItemManifesto> itemManifestoJSONs) {
		this.itemManifestoJSONs = itemManifestoJSONs;
	}

	public String getCnpDestinador() {
		return cnpDestinador;
	}

	public void setCnpDestinador(String cnpDestinador) {
		this.cnpDestinador = cnpDestinador;
	}

	public Integer getCodUnidadeDestinador() {
		return codUnidadeDestinador;
	}

	public void setCodUnidadeDestinador(Integer codUnidadeDestinador) {
		this.codUnidadeDestinador = codUnidadeDestinador;
	}
	
	

}
