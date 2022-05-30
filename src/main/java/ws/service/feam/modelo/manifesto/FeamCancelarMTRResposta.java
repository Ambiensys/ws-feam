package ws.service.feam.modelo.manifesto;

public class FeamCancelarMTRResposta {
	
	private Integer manifestoCodigo;
	private String justificativa;
	private Integer retornoCodigo;
	private String retorno;

	public FeamCancelarMTRResposta() {
	}

	public Integer getManifestoCodigo() {
		return this.manifestoCodigo;
	}

	public void setManifestoCodigo(Integer manifestoCodigo) {
		this.manifestoCodigo = manifestoCodigo;
	}

	public String getJustificativa() {
		return this.justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Integer getRetornoCodigo() {
		return this.retornoCodigo;
	}

	public void setRetornoCodigo(Integer retornoCodigo) {
		this.retornoCodigo = retornoCodigo;
	}

	public String getRetorno() {
		return this.retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}
}
