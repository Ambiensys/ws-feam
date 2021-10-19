package ws.integracao.feam.exception.geral;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import ws.integracao.feam.erro.ErroInternoBean;
import ws.integracao.feam.exception.FeamException;

public class ErroInternoException extends FeamException{

    @Inject
    Logger logger =  Logger.getLogger(ErroInternoException.class);;
        
    public ErroInternoException(Exception e){
        super(e, new ErroInternoBean());
        
        logger.error(e.getMessage());
        if (e.getCause() != null)
            logger.error(e.getCause().getMessage());

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);

        logger.error(sw.toString());
    }
}