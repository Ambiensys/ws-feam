package ws.service.feam.exception.geral;

import ws.service.feam.erro.ErroNotFoundBean;
import ws.service.feam.exception.FeamException;

public class NotFoundException extends FeamException{
    public NotFoundException(String mensagem){
        super(new ErroNotFoundBean(mensagem));
    }
}