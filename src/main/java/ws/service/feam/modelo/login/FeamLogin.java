package ws.service.feam.modelo.login;

public class FeamLogin {

    private Integer pessoaCodigo;
    private String  pessoaCnpj;
    private String  usuarioCpf;
    private String  senha;
    
    public Integer getPessoaCodigo() {
        return pessoaCodigo;
    }

    public void setPessoaCodigo(Integer pessoaCodigo) {
        this.pessoaCodigo = pessoaCodigo;
    }

    public String getPessoaCnpj() {
        return pessoaCnpj;
    }

    public void setPessoaCnpj(String pessoaCnpj) {
        this.pessoaCnpj = pessoaCnpj;
    }

    public String getUsuarioCpf() {
        return usuarioCpf;
    }

    public void setUsuarioCpf(String usuarioCpf) {
        this.usuarioCpf = usuarioCpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}