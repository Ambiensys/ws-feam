package ws.integracao.feam.erro;

import javax.ws.rs.core.Response.Status;

public class ErroDadosInvalidosBean extends ErroBean{
    public static final int codigo = Status.BAD_REQUEST.getStatusCode();

    public ErroDadosInvalidosBean(String msg){
        super(codigo, msg);
    }
}