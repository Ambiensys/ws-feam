package ws.service.feam.exception;

import ws.service.feam.erro.ErroBean;

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

	public void setErroBean(ErroBean erroBean) {
		this.erroBean = erroBean;
	}

	public FeamException erroBean(ErroBean erroBean) {
		setErroBean(erroBean);
		return this;
	}

}
