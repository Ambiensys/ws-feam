package ws.service.feam.modelo.manifesto;

public class FeamResiduo {
    private Integer resCodigo;
    private String  resCodigoIbama;
    private String  resDescricao;
    private String  grrDescricao;
    private String  grrRepresentacao;
    private boolean resProdutoPerigoso;

    public Integer getResCodigo() {
        return resCodigo;
    }

    public void setResCodigo(Integer resCodigo) {
        this.resCodigo = resCodigo;
    }

    public String getResCodigoIbama() {
        return resCodigoIbama;
    }

    public void setResCodigoIbama(String resCodigoIbama) {
        this.resCodigoIbama = resCodigoIbama;
    }

    public String getResDescricao() {
        return resDescricao;
    }

    public void setResDescricao(String resDescricao) {
        this.resDescricao = resDescricao;
    }

    public String getGrrDescricao() {
        return grrDescricao;
    }

    public void setGrrDescricao(String grrDescricao) {
        this.grrDescricao = grrDescricao;
    }

    public String getGrrRepresentacao() {
        return grrRepresentacao;
    }

    public void setGrrRepresentacao(String grrRepresentacao) {
        this.grrRepresentacao = grrRepresentacao;
    }
    
    public boolean isResProdutoPerigoso() {
        return resProdutoPerigoso;
    }
    
    public void setResProdutoPerigoso(boolean resProdutoPerigoso) {
        this.resProdutoPerigoso = resProdutoPerigoso;
    }


}
