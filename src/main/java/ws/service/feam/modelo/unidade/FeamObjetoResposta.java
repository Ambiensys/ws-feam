package ws.service.feam.modelo.unidade;

public class FeamObjetoResposta {            
    private int    parCodigo;
    private String parDescricao;
    private String jurCnpj;
    private String fisCpf;
    private String paeEndereco;

    public int getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(int parCodigo) {
        this.parCodigo = parCodigo;
    }

    public String getParDescricao() {
        return parDescricao;
    }

    public void setParDescricao(String parDescricao) {
        this.parDescricao = parDescricao;
    }

    public String getJurCnpj() {
        return jurCnpj;
    }

    public void setJurCnpj(String jurCnpj) {
        this.jurCnpj = jurCnpj;
    }

    public String getFisCpf() {
        return fisCpf;
    }

    public void setFisCpf(String fisCpf) {
        this.fisCpf = fisCpf;
    }

    public String getPaeEndereco() {
        return paeEndereco;
    }

    public void setPaeEndereco(String paeEndereco) {
        this.paeEndereco = paeEndereco;
    }
}
