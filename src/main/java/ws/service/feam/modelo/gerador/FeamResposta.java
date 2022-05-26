package ws.service.feam.modelo.gerador;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class FeamResposta {
	
	private int statusCode;
	private String message;
	private List<FeamRespostaManifesto> manifestoJSONDtos;
	
	@JsonProperty(value="manifestoJSONDtos")
	public List<FeamRespostaManifesto> getManifestoJSONDtos() {
		return manifestoJSONDtos;
	}

	public void setManifestoJSONDtos(List<FeamRespostaManifesto> manifestoJSONDtos) {
		this.manifestoJSONDtos = manifestoJSONDtos;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

   
}
