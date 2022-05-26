package ws.service.feam.exception.geral;

import ws.service.feam.erro.ErroDadosInvalidosBean;
import ws.service.feam.exception.FeamException;

public class DadosInvalidoException extends FeamException{
    public DadosInvalidoException(String mensagem){
        super(new ErroDadosInvalidosBean(mensagem));
    }
}