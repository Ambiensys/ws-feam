package ws.service.feam.modelo.login;

import java.io.Serializable;

public class FeamLoginResposta implements Serializable {

    private Object mensagem;
    private FeamParceiroLoginResposta objetoResposta;
    private boolean erro;

    public Object getMensagem() {
        return mensagem;
    }

    public void setMensagem(Object mensagem) {
        this.mensagem = mensagem;
    }

    public FeamParceiroLoginResposta getObjetoResposta() {
        return objetoResposta;
    }

    public void setObjetoResposta(FeamParceiroLoginResposta objetoResposta) {
        this.objetoResposta = objetoResposta;
    }

    public boolean isErro() {
        return erro;
    }

    public void setErro(boolean erro) {
        this.erro = erro;
    }

}
