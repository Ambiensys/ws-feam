package ws.service.feam.modelo.login;

public class FeamLoginCdCliente {

    private Integer cdCliente;
    private FeamLogin  feamLogin;

    public FeamLoginCdCliente() {
    }

    public Integer getCdCliente() {
        return this.cdCliente;
    }

    public void setCdCliente(Integer cdCliente) {
        this.cdCliente = cdCliente;
    }

    public FeamLogin getFeamLogin() {
        return this.feamLogin;
    }

    public void setFeamLogin(FeamLogin feamLogin) {
        this.feamLogin = feamLogin;
    }
    
}