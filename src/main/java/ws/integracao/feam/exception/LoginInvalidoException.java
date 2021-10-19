package ws.integracao.feam.exception;

import ws.integracao.feam.erro.ErroDadosInvalidosBean;

public class LoginInvalidoException extends FeamException{
    public LoginInvalidoException(String mensagem){
        super(new ErroDadosInvalidosBean(mensagem));
    }
}