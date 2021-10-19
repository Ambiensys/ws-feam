package ws.integracao.feam.exception.geral;

import ws.integracao.feam.erro.ErroServiceRemotoBean;
import ws.integracao.feam.exception.FeamException;

public class ErroServicoRemotoException extends FeamException{
    public ErroServicoRemotoException(Exception e, Object service, String descErro){
        super(e, new ErroServiceRemotoBean(service.getClass().getSimpleName(), descErro));
    }

    public ErroServicoRemotoException(Exception e, Object service, Integer status, String descErro){
        super(e, new ErroServiceRemotoBean(status, service.getClass().getSimpleName(), descErro));
    }

    public ErroServicoRemotoException(Exception e, Object service){
        super(e, new ErroServiceRemotoBean(service.getClass().getSimpleName()));
    }
}
