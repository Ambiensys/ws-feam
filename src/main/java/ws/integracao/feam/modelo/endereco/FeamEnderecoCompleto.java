package ws.integracao.feam.modelo.endereco;

public class FeamEnderecoCompleto {
    private String cepNumero;
    private FeamCidade cidade;
    private FeamEstado estado;
    private String cepLogradouro;
    private String cepBairro;

    public String getCepNumero() {
        return cepNumero;
    }

    public void setCepNumero(String cepNumero) {
        this.cepNumero = cepNumero;
    }

    public FeamCidade getCidade() {
		return cidade;
	}

	public void setCidade(FeamCidade cidade) {
		this.cidade = cidade;
	}

	public FeamEstado getEstado() {
		return estado;
	}

	public void setEstado(FeamEstado estado) {
		this.estado = estado;
	}

	public String getCepLogradouro() {
        return cepLogradouro;
    }

    public void setCepLogradouro(String cepLogradouro) {
        this.cepLogradouro = cepLogradouro;
    }

    public String getCepBairro() {
        return cepBairro;
    }

    public void setCepBairro(String cepBairro) {
        this.cepBairro = cepBairro;
    }


}
