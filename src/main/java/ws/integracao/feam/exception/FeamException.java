package ws.integracao.feam.exception;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import ws.integracao.feam.erro.ErroBean;

public class FeamException extends Exception
{
	private static final long serialVersionUID = 1L;

	private ErroBean erroBean;

	public FeamException() {
	}

	public FeamException(Exception e) {
		super(e);
	}	

	public FeamException(ErroBean erroBean) {
		this.erroBean = erroBean;
	}

	public FeamException(Exception e, ErroBean erroBean) {
		super(e);
		this.erroBean = erroBean;
	}

	public ErroBean getErroBean() {
		return this.erroBean;
	}

	public String getErroBeanJson() {
        Jsonb jsonb = JsonbBuilder.create();
		ErroBean erro = new ErroBean(this.erroBean.getCodigoErro(), this.erroBean.getMensagem());
        String erroJson = jsonb.toJson(erro);		
		return erroJson;	
	}

	public void setErroBean(ErroBean erroBean) {
		this.erroBean = erroBean;
	}

	public FeamException erroBean(ErroBean erroBean) {
		setErroBean(erroBean);
		return this;
	}

}
