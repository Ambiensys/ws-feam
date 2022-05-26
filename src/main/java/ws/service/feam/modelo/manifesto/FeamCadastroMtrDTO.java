package ws.service.feam.modelo.manifesto;

import java.util.List;

public class FeamCadastroMtrDTO {

	private String hdnGeradorCodigo;
	private String txtGeradorDataExpedicao;//data de emissao
	private String txtGeradorRespExpedicao;//Responsavel pela emissao
	private String txtGeradorRespCargo;//Cargo
	private String hdnTransportadorCodigo;// Codigo do transportador - Carregado pelo CNPJ
	private String txtTransportadorDataExpedicao;// Data do Transporte
	private String txtTransportadorNomeMotorista;// Motorista
	private String txtTransportadorPlacaVeiculo;// Placa Veiculo
	private String hdnDestinadorCodigo;// Codigo do destinador - carregado pelo CNPJ
	private String txtObservacoes;// Observacao	
        private String hdnArmazenadorCodigo; // Codigo do Armazenador
	private String txtDi;
	private String txtPortoDeOrigem;
	private String txtPortoDeDestino;
	private String txtCodigoMtrProvisorio;
	private String cmbPais;
	private String txtTransInternacionalEndereco;
	private String txtTransInternacionalMunicipio;
        
	private List<ItensResiduoManifesto> itensManifesto; //Lista de Manifesto


	public String getHdnGeradorCodigo() {
		return hdnGeradorCodigo;
	}

	public void setHdnGeradorCodigo(String hdnGeradorCodigo) {
		this.hdnGeradorCodigo = hdnGeradorCodigo;
	}

	public String getTxtGeradorDataExpedicao() {
		return txtGeradorDataExpedicao;
	}

	public void setTxtGeradorDataExpedicao(String txtGeradorDataExpedicao) {
		this.txtGeradorDataExpedicao = txtGeradorDataExpedicao;
	}

	public String getTxtGeradorRespExpedicao() {
		return txtGeradorRespExpedicao;
	}

	public void setTxtGeradorRespExpedicao(String txtGeradorRespExpedicao) {
		this.txtGeradorRespExpedicao = txtGeradorRespExpedicao;
	}

	public String getTxtGeradorRespCargo() {
		return txtGeradorRespCargo;
	}

	public void setTxtGeradorRespCargo(String txtGeradorRespCargo) {
		this.txtGeradorRespCargo = txtGeradorRespCargo;
	}

	public String getHdnTransportadorCodigo() {
		return hdnTransportadorCodigo;
	}

	public void setHdnTransportadorCodigo(String hdnTransportadorCodigo) {
		this.hdnTransportadorCodigo = hdnTransportadorCodigo;
	}

	public String getTxtTransportadorDataExpedicao() {
		return txtTransportadorDataExpedicao;
	}

	public void setTxtTransportadorDataExpedicao(String txtTransportadorDataExpedicao) {
		this.txtTransportadorDataExpedicao = txtTransportadorDataExpedicao;
	}

	public String getTxtTransportadorNomeMotorista() {
		return txtTransportadorNomeMotorista;
	}

	public void setTxtTransportadorNomeMotorista(String txtTransportadorNomeMotorista) {
		this.txtTransportadorNomeMotorista = txtTransportadorNomeMotorista;
	}

	public String getTxtTransportadorPlacaVeiculo() {
		return txtTransportadorPlacaVeiculo;
	}

	public void setTxtTransportadorPlacaVeiculo(String txtTransportadorPlacaVeiculo) {
		this.txtTransportadorPlacaVeiculo = txtTransportadorPlacaVeiculo;
	}

	public String getHdnDestinadorCodigo() {
		return hdnDestinadorCodigo;
	}

	public void setHdnDestinadorCodigo(String hdnDestinadorCodigo) {
		this.hdnDestinadorCodigo = hdnDestinadorCodigo;
	}

	public String getTxtObservacoes() {
		return txtObservacoes;
	}

	public void setTxtObservacoes(String txtObservacoes) {
		this.txtObservacoes = txtObservacoes;
	}
        
        
        public String getHdnArmazenadorCodigo() {
            return hdnArmazenadorCodigo;
        }

        public void setHdnArmazenadorCodigo(String hdnArmazenadorCodigo) {
            this.hdnArmazenadorCodigo = hdnArmazenadorCodigo;
        }

        public String getTxtDi() {
            return txtDi;
        }

        public void setTxtDi(String txtDi) {
            this.txtDi = txtDi;
        }

        public String getTxtPortoDeOrigem() {
            return txtPortoDeOrigem;
        }

        public void setTxtPortoDeOrigem(String txtPortoDeOrigem) {
            this.txtPortoDeOrigem = txtPortoDeOrigem;
        }

        public String getTxtPortoDeDestino() {
            return txtPortoDeDestino;
        }

        public void setTxtPortoDeDestino(String txtPortoDeDestino) {
            this.txtPortoDeDestino = txtPortoDeDestino;
        }

        public String getTxtCodigoMtrProvisorio() {
            return txtCodigoMtrProvisorio;
        }

        public void setTxtCodigoMtrProvisorio(String txtCodigoMtrProvisorio) {
            this.txtCodigoMtrProvisorio = txtCodigoMtrProvisorio;
        }

        public String getCmbPais() {
            return cmbPais;
        }

        public void setCmbPais(String cmbPais) {
            this.cmbPais = cmbPais;
        }

        public String getTxtTransInternacionalEndereco() {
            return txtTransInternacionalEndereco;
        }

        public void setTxtTransInternacionalEndereco(String txtTransInternacionalEndereco) {
            this.txtTransInternacionalEndereco = txtTransInternacionalEndereco;
        }

        public String getTxtTransInternacionalMunicipio() {
            return txtTransInternacionalMunicipio;
        }

        public void setTxtTransInternacionalMunicipio(String txtTransInternacionalMunicipio) {
            this.txtTransInternacionalMunicipio = txtTransInternacionalMunicipio;
        }
        
	public List<ItensResiduoManifesto> getItensManifesto() {
		return itensManifesto;
	}

	public void setItensManifesto(List<ItensResiduoManifesto> itensManifesto) {
		this.itensManifesto = itensManifesto;
	}



}
