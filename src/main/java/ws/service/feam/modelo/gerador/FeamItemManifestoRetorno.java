package ws.service.feam.modelo.gerador;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class FeamItemManifestoRetorno {

	
	private Integer codigoSequencial;
	private String justificativa;
	private Integer codigoInterno;
	private Integer quantidade;
	private Integer quantidadeRecebida;
	private String residuo;
	private Integer codigoAcondicionamento;
	private Integer codigoClasse;
	private Integer codigoTecnologia;
	private Integer codigoTipoEstado;
	private Integer codigoUnidade;
	private String manifestoItemObservacao;
	private String manifestoItemCodInterno;
	private String manifestoItemCodInternoDestinador;
	private String tipoDensidadeValor;
	private String tipoDensidadeUnidade;
	private String numeroONU;
	private String classeDeRisco;
	private String nomeEmbarque;
	private String grupoEmbalagem;

	public Integer getCodigoSequencial() {
		return codigoSequencial;
	}

	public void setCodigoSequencial(Integer codigoSequencial) {
		this.codigoSequencial = codigoSequencial;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Integer getCodigoInterno() {
		return codigoInterno;
	}

	public void setCodigoInterno(Integer codigoInterno) {
		this.codigoInterno = codigoInterno;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getQuantidadeRecebida() {
		return quantidadeRecebida;
	}

	public void setQuantidadeRecebida(Integer quantidadeRecebida) {
		this.quantidadeRecebida = quantidadeRecebida;
	}

	public String getResiduo() {
		return residuo;
	}

	public void setResiduo(String residuo) {
		this.residuo = residuo;
	}

	public Integer getCodigoAcondicionamento() {
		return codigoAcondicionamento;
	}

	public void setCodigoAcondicionamento(Integer codigoAcondicionamento) {
		this.codigoAcondicionamento = codigoAcondicionamento;
	}

	public Integer getCodigoClasse() {
		return codigoClasse;
	}

	public void setCodigoClasse(Integer codigoClasse) {
		this.codigoClasse = codigoClasse;
	}

	public Integer getCodigoTecnologia() {
		return codigoTecnologia;
	}

	public void setCodigoTecnologia(Integer codigoTecnologia) {
		this.codigoTecnologia = codigoTecnologia;
	}

	public Integer getCodigoTipoEstado() {
		return codigoTipoEstado;
	}

	public void setCodigoTipoEstado(Integer codigoTipoEstado) {
		this.codigoTipoEstado = codigoTipoEstado;
	}

	public Integer getCodigoUnidade() {
		return codigoUnidade;
	}

	public void setCodigoUnidade(Integer codigoUnidade) {
		this.codigoUnidade = codigoUnidade;
	}

	public String getManifestoItemObservacao() {
		return manifestoItemObservacao;
	}

	public void setManifestoItemObservacao(String manifestoItemObservacao) {
		this.manifestoItemObservacao = manifestoItemObservacao;
	}

	public String getManifestoItemCodInterno() {
		return manifestoItemCodInterno;
	}

	public void setManifestoItemCodInterno(String manifestoItemCodInterno) {
		this.manifestoItemCodInterno = manifestoItemCodInterno;
	}

	public String getManifestoItemCodInternoDestinador() {
		return manifestoItemCodInternoDestinador;
	}

	public void setManifestoItemCodInternoDestinador(String manifestoItemCodInternoDestinador) {
		this.manifestoItemCodInternoDestinador = manifestoItemCodInternoDestinador;
	}

	public String getTipoDensidadeValor() {
		return tipoDensidadeValor;
	}

	public void setTipoDensidadeValor(String tipoDensidadeValor) {
		this.tipoDensidadeValor = tipoDensidadeValor;
	}

	public String getTipoDensidadeUnidade() {
		return tipoDensidadeUnidade;
	}

	public void setTipoDensidadeUnidade(String tipoDensidadeUnidade) {
		this.tipoDensidadeUnidade = tipoDensidadeUnidade;
	}

	public String getNumeroONU() {
		return numeroONU;
	}

	public void setNumeroONU(String numeroONU) {
		this.numeroONU = numeroONU;
	}

	public String getClasseDeRisco() {
		return classeDeRisco;
	}

	public void setClasseDeRisco(String classeDeRisco) {
		this.classeDeRisco = classeDeRisco;
	}

	public String getNomeEmbarque() {
		return nomeEmbarque;
	}

	public void setNomeEmbarque(String nomeEmbarque) {
		this.nomeEmbarque = nomeEmbarque;
	}

	public String getGrupoEmbalagem() {
		return grupoEmbalagem;
	}

	public void setGrupoEmbalagem(String grupoEmbalagem) {
		this.grupoEmbalagem = grupoEmbalagem;
	}

}
