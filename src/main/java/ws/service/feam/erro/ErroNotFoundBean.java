package ws.service.feam.erro;

import javax.ws.rs.core.Response.Status;

public class ErroNotFoundBean extends ErroBean{
    public static final int codigo = Status.NOT_FOUND.getStatusCode();

    public ErroNotFoundBean(String msg){
        super(codigo, msg);
    }
}