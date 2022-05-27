package ws.service.feam.modelo.login;

public class FeamLoginRespostaWS {

    private String mensagem;
    private int code;    
    
    private Integer pessoaCodigo;
    private String  pessoaCnpj;
    private String  pessoaNome;
    private Integer usuarioCodigo;
    private String  usuarioNome;
    private String  usuarioCpf;
    private String  token;
    private String  chave;
    private String  senha;
    private String  retorno;
    private Integer retornoCodigo;
        
    public String getMensagem() {
        return mensagem;
    }
    
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public int getCode() {
        return code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }    
    
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

    public String getPessoaNome() {
        return pessoaNome;
    }

    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    public Integer getUsuarioCodigo() {
        return usuarioCodigo;
    }

    public void setUsuarioCodigo(Integer usuarioCodigo) {
        this.usuarioCodigo = usuarioCodigo;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getUsuarioCpf() {
        return usuarioCpf;
    }

    public void setUsuarioCpf(String usuarioCpf) {
        this.usuarioCpf = usuarioCpf;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public Integer getRetornoCodigo() {
        return retornoCodigo;
    }

    public void setRetornoCodigo(Integer retornoCodigo) {
        this.retornoCodigo = retornoCodigo;
    }
}