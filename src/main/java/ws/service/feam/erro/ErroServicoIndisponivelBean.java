package ws.service.feam.erro;

import javax.ws.rs.core.Response.Status;

import ws.service.feam.util.Constante;

public class ErroServicoIndisponivelBean extends ErroBean{
    public static final int codigo = Status.SERVICE_UNAVAILABLE.getStatusCode();
	public static final String erro = Constante.SERVICE_UNAVAILABLE_ERROR_MESSAGE;

    public ErroServicoIndisponivelBean(String service){
        super(codigo, service.concat(erro));
    }
}
