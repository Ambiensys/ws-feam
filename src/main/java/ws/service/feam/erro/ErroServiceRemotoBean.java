package ws.service.feam.erro;

import javax.ws.rs.core.Response.Status;

import ws.service.feam.util.Constante;

public class ErroServiceRemotoBean extends ErroBean{
    public static final int codigo = Status.BAD_REQUEST.getStatusCode();
	public static final String erro = Constante.BAD_REMOTE_REQUEST_ERROR_MESSAGE;

    public ErroServiceRemotoBean(String service){
        super(codigo, service.concat(erro));
    }

    public ErroServiceRemotoBean(String service, String descErro) {
        super(codigo, service.concat(erro).concat(" ").concat(descErro));
    }

    public ErroServiceRemotoBean(Integer status, String service, String descErro) {
        super(status, service.concat(erro).concat(" ").concat(descErro));
    }
    
}
