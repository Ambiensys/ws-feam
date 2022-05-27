package ws.service.feam.modelo.gerador;

import java.io.Serializable;

public class FeamItemManifesto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Float   quantidade;
	private String  residuo;
	private Integer codigoAcondicionamento;
	private Integer codigoClasse;
	private Integer codigoTecnologia;
	private Integer codigoTipoEstado;
	private Integer codigoUnidade;
	private String  manifestoItemObservacao;
	private String  manifestoItemCodInterno;
	private String  manifestoItemCodInternoDestinador;
	private Integer tipoDensidadeValor;
	private Integer tipoDensidadeUnidade;
	private String  classeDeRisco;
	private String  numeroONU;

	public Float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
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

	public Integer getTipoDensidadeValor() {
		return tipoDensidadeValor;
	}

	public void setTipoDensidadeValor(Integer tipoDensidadeValor) {
		this.tipoDensidadeValor = tipoDensidadeValor;
	}

	public Integer getTipoDensidadeUnidade() {
		return tipoDensidadeUnidade;
	}

	public void setTipoDensidadeUnidade(Integer tipoDensidadeUnidade) {
		this.tipoDensidadeUnidade = tipoDensidadeUnidade;
	}

	public String getClasseDeRisco() {
		return classeDeRisco;
	}

	public void setClasseDeRisco(String classeDeRisco) {
		this.classeDeRisco = classeDeRisco;
	}

	public String getNumeroONU() {
		return numeroONU;
	}

	public void setNumeroONU(String numeroONU) {
		this.numeroONU = numeroONU;
	}

}
