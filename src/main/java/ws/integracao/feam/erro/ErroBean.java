package ws.integracao.feam.erro;

public class ErroBean {
	private int codigoErro;
	private String mensagem;
	
	public ErroBean() {
	}

	public ErroBean(int codigo) {
		this.codigoErro = codigo;
	}

	public ErroBean(int codigo, String mensagem) {
		this.codigoErro = codigo;
		this.mensagem = mensagem;
	}

	public int getCodigoErro() {
		return codigoErro;
	}

	public void setCodigoErro(int codigoErro) {
		this.codigoErro = codigoErro;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
