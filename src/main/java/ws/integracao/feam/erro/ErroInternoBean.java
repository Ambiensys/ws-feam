package ws.integracao.feam.erro;

import javax.ws.rs.core.Response.Status;

import ws.integracao.feam.modelo.utils.Constante;

public class ErroInternoBean extends ErroBean{
    public static final int codigo = Status.INTERNAL_SERVER_ERROR.getStatusCode();
	public static final String erro = Constante.INTERNAL_SERVER_ERROR_MESSAGE;

    public ErroInternoBean(){
        super(codigo, erro);
    }
}
