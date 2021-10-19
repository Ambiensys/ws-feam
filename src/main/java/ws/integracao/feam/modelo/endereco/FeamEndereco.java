package ws.integracao.feam.modelo.endereco;

public class FeamEndereco {
    private Object mensagem;
    private FeamEnderecoCompleto objetoResposta;
    private boolean erro;
    
    public Object getMensagem() {
        return mensagem;
    }

    public void setMensagem(Object mensagem) {
        this.mensagem = mensagem;
    }

    public FeamEnderecoCompleto getObjetoResposta() {
        return objetoResposta;
    }

    public void setObjetoResposta(FeamEnderecoCompleto objetoResposta) {
        this.objetoResposta = objetoResposta;
    }

    public boolean isErro() {
        return erro;
    }

    public void setErro(boolean erro) {
        this.erro = erro;
    }
}
