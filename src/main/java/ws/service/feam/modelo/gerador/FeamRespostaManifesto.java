package ws.service.feam.modelo.gerador;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class FeamRespostaManifesto {


	private Integer manifestoCodigo;
	private Integer seuCodigoReferencia;
	private Integer retornoCodigo;
	private String cnpGerador;
	private Integer codUnidadeGerador;
	private String cnpTransportador;
	private Integer codUnidadeTransportador;
	private String cnpDestinador;
	private Integer codUnidadeDestinador;
	private String cnpArmazenador;
	private Integer codUnidadeArmazenador;
	private Integer situacaoManifestoCodigo;
	private String manifData;
	private String manifDataExpedicao;
	private String manifObservacao;
	private String manifDataRecebimento;
	private String manifGeradorNomeResponsavel;
	private String manifGeradorCargoResponsavel;
	private String manifTransportadorNomeMotorista;
	private String manifTransportadorPlacaVeiculo;
	private String manifTransportadorDataExpedicao;
	private String retorno;

	private List<FeamItemManifestoRetorno> itemManifestoJSONs;

	public Integer getManifestoCodigo() {
		return manifestoCodigo;
	}

	public void setManifestoCodigo(Integer manifestoCodigo) {
		this.manifestoCodigo = manifestoCodigo;
	}

	public Integer getSeuCodigoReferencia() {
		return seuCodigoReferencia;
	}

	public void setSeuCodigoReferencia(Integer seuCodigoReferencia) {
		this.seuCodigoReferencia = seuCodigoReferencia;
	}

	public Integer getRetornoCodigo() {
		return retornoCodigo;
	}

	public void setRetornoCodigo(Integer retornoCodigo) {
		this.retornoCodigo = retornoCodigo;
	}

	public String getCnpGerador() {
		return cnpGerador;
	}

	public void setCnpGerador(String cnpGerador) {
		this.cnpGerador = cnpGerador;
	}

	public Integer getCodUnidadeGerador() {
		return codUnidadeGerador;
	}

	public void setCodUnidadeGerador(Integer codUnidadeGerador) {
		this.codUnidadeGerador = codUnidadeGerador;
	}

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

	public Integer getSituacaoManifestoCodigo() {
		return situacaoManifestoCodigo;
	}

	public void setSituacaoManifestoCodigo(Integer situacaoManifestoCodigo) {
		this.situacaoManifestoCodigo = situacaoManifestoCodigo;
	}

	public String getManifData() {
		return manifData;
	}

	public void setManifData(String manifData) {
		this.manifData = manifData;
	}

	public String getManifDataExpedicao() {
		return manifDataExpedicao;
	}

	public void setManifDataExpedicao(String manifDataExpedicao) {
		this.manifDataExpedicao = manifDataExpedicao;
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

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public List<FeamItemManifestoRetorno> getItemManifestoJSONs() {
		return itemManifestoJSONs;
	}

	public void setItemManifestoJSONs(List<FeamItemManifestoRetorno> itemManifestoJSONs) {
		this.itemManifestoJSONs = itemManifestoJSONs;
	}

	public String getManifDataRecebimento() {
		return manifDataRecebimento;
	}

	public void setManifDataRecebimento(String manifDataRecebimento) {
		this.manifDataRecebimento = manifDataRecebimento;
	}
	

}
