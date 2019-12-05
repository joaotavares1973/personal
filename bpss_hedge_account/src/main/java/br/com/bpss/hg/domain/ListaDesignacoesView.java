package br.com.bpss.hg.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TTH002_J_LISTA_DESIGNACOES")
public class ListaDesignacoesView implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "DESIGNACAO")
	private String cdDesignacaodesignacao;

	@Column(name = "TIPO_INSTRUMENTO")
	private String cdTipoInstrumento;

	@Column(name = "DS_TIPO_INSTRUMENTO")
	private String dsTipoInstrumento;

	@Column(name = "CD_GRP_PRODUTO")
	private String cdGrpProduto;

	@Column(name = "NM_GRP_PRODUTO")
	private String nmGrpProduto;

	@Column(name = "DT_ALOCACAO")
	private String dtAlocacao;

	@Column(name = "ANO_SAFRA")
	private String anoSafra;

	@Column(name = "MES_ANO")
	private String mesAno;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "OBJETO_HEDGE")
	private String objetoHedge;

	@Column(name = "QTDE_FISICA")
	private String qtdeFisica;

	@Column(name = "QTDE_HEDGE")
	private String qtdeHedge;

	public String getCdDesignacaodesignacao() {
		return cdDesignacaodesignacao;
	}

	public void setCdDesignacaodesignacao(String cdDesignacaodesignacao) {
		this.cdDesignacaodesignacao = cdDesignacaodesignacao;
	}

	public String getCdTipoInstrumento() {
		return cdTipoInstrumento;
	}

	public void setCdTipoInstrumento(String cdTipoInstrumento) {
		this.cdTipoInstrumento = cdTipoInstrumento;
	}

	public String getDsTipoInstrumento() {
		return dsTipoInstrumento;
	}

	public void setDsTipoInstrumento(String dsTipoInstrumento) {
		this.dsTipoInstrumento = dsTipoInstrumento;
	}

	public String getCdGrpProduto() {
		return cdGrpProduto;
	}

	public void setCdGrpProduto(String cdGrpProduto) {
		this.cdGrpProduto = cdGrpProduto;
	}

	public String getNmGrpProduto() {
		return nmGrpProduto;
	}

	public void setNmGrpProduto(String nmGrpProduto) {
		this.nmGrpProduto = nmGrpProduto;
	}

	public String getDtAlocacao() {
		return dtAlocacao;
	}

	public void setDtAlocacao(String dtAlocacao) {
		this.dtAlocacao = dtAlocacao;
	}

	public String getAnoSafra() {
		return anoSafra;
	}

	public void setAnoSafra(String anoSafra) {
		this.anoSafra = anoSafra;
	}

	public String getMesAno() {
		return mesAno;
	}

	public void setMesAno(String mesAno) {
		this.mesAno = mesAno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObjetoHedge() {
		return objetoHedge;
	}

	public void setObjetoHedge(String objetoHedge) {
		this.objetoHedge = objetoHedge;
	}

	public String getQtdeFisica() {
		return qtdeFisica;
	}

	public void setQtdeFisica(String qtdeFisica) {
		this.qtdeFisica = qtdeFisica;
	}

	public String getQtdeHedge() {
		return qtdeHedge;
	}

	public void setQtdeHedge(String qtdeHedge) {
		this.qtdeHedge = qtdeHedge;
	}

}
