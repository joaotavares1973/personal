package br.com.bpss.hg.dto;

public class GestaoOperacoesDTO {

	String cdContrato;
	String dsTipoOperacao;
	String nmGrpProduto;
	String mesAno;
	String nmFixacaoTipo;
	String qtde;
	String vlFixado;
	String status;
	String anoSafra;

	public String getCdContrato() {
		return cdContrato;
	}

	public void setCdContrato(String cdContrato) {
		this.cdContrato = cdContrato;
	}

	public String getDsTipoOperacao() {
		return dsTipoOperacao;
	}

	public void setDsTipoOperacao(String dsTipoOperacao) {
		this.dsTipoOperacao = dsTipoOperacao;
	}

	public String getNmGrpProduto() {
		return nmGrpProduto;
	}

	public void setNmGrpProduto(String nmGrpProduto) {
		this.nmGrpProduto = nmGrpProduto;
	}

	public String getMesAno() {
		return mesAno;
	}

	public void setMesAno(String mesAno) {
		this.mesAno = mesAno;
	}

	public String getNmFixacaoTipo() {
		return nmFixacaoTipo;
	}

	public void setNmFixacaoTipo(String nmFixacaoTipo) {
		this.nmFixacaoTipo = nmFixacaoTipo;
	}

	public String getQtde() {
		return qtde;
	}

	public void setQtde(String qtde) {
		this.qtde = qtde;
	}

	public String getVlFixado() {
		return vlFixado;
	}

	public void setVlFixado(String vlFixado) {
		this.vlFixado = vlFixado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAnoSafra() {
		return anoSafra;
	}

	public void setAnoSafra(String anoSafra) {
		this.anoSafra = anoSafra;
	}

}
