package ws.integracao.feam.exception;

import ws.integracao.feam.erro.ErroServicoIndisponivelBean;
import ws.integracao.feam.service.FeamService;

public class FeamServiceUnavailableException extends FeamException{
    public FeamServiceUnavailableException(Exception e){
        super(e, new ErroServicoIndisponivelBean(FeamService.class.getSimpleName()));
    }

    public FeamServiceUnavailableException(){
        super(new ErroServicoIndisponivelBean(FeamService.class.getSimpleName()));
    }
}
