package ws.integracao.feam.exception;

import ws.integracao.feam.erro.ErroDadosInvalidosBean;

public class DadosInvalidoException extends FeamException{
    public DadosInvalidoException(String mensagem){
        super(new ErroDadosInvalidosBean(mensagem));
    }
}