package ws.service.feam.exception.geral;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ws.service.feam.erro.ErroInternoBean;
import ws.service.feam.exception.FeamException;
import ws.service.feam.util.FeamLogArquivo;

public class ErroInternoException extends FeamException{

    public ErroInternoException(Exception e){
        super(e, new ErroInternoBean(e.getMessage()));
        erroLog(e);
    }

    public ErroInternoException(String mensagem){
        super(new ErroInternoBean(mensagem));
    }

    public ErroInternoException(Exception e, String mensagem){
        super(e, new ErroInternoBean(mensagem));
        erroLog(e);
    }

    public void erroLog(Exception e){
        FeamLogArquivo logArquivo = new FeamLogArquivo(ErroInternoException.class.getName());
        try {
            Logger log = logArquivo.start();
            
            log.error(e.getMessage());
            if (e.getCause() != null)
            log.error(e.getCause().getMessage());

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            log.error(sw.toString());
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
    }
}