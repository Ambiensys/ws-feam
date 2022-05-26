package ws.service.feam.erro;

public class ErroBean {
	private Boolean erro;
	private Integer status;
	private String mensagem;
	
	public ErroBean() {
	}

	public ErroBean(Integer codigo) {
		this.status = codigo;
	}

	public ErroBean(Integer codigo, String mensagem) {
		this.status = codigo;
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public Boolean isErro() {
		return this.erro;
	}

	public Boolean getErro() {
		return this.erro;
	}

	public void setErro(Boolean erro) {
		this.erro = erro;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
