/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bpss.hg.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "TTH001_J_OPER_NAO_DESIGNADAS_H", catalog = "", schema = "HEDGE_AGRARIA")
@Access(value = AccessType.FIELD)
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Tth001JOperNaoDesignadasH.findAll", query = "SELECT t FROM Tth001JOperNaoDesignadasH t"),
		@NamedQuery(name = "Tth001JOperNaoDesignadasH.findByContrato", query = "SELECT t FROM Tth001JOperNaoDesignadasH t WHERE t.contrato = :contrato"),
		@NamedQuery(name = "Tth001JOperNaoDesignadasH.findByTipoInstrumento", query = "SELECT t FROM Tth001JOperNaoDesignadasH t WHERE t.tipoInstrumento = :tipoInstrumento"),
		@NamedQuery(name = "Tth001JOperNaoDesignadasH.findByNmFixacaoTipo", query = "SELECT t FROM Tth001JOperNaoDesignadasH t WHERE t.nmFixacaoTipo = :nmFixacaoTipo"),
		@NamedQuery(name = "Tth001JOperNaoDesignadasH.findByCdGrpProduto", query = "SELECT t FROM Tth001JOperNaoDesignadasH t WHERE t.cdGrpProduto = :cdGrpProduto"),
		@NamedQuery(name = "Tth001JOperNaoDesignadasH.findByNmGrpProduto", query = "SELECT t FROM Tth001JOperNaoDesignadasH t WHERE t.nmGrpProduto = :nmGrpProduto"),
		@NamedQuery(name = "Tth001JOperNaoDesignadasH.findByCdTipoOperacao", query = "SELECT t FROM Tth001JOperNaoDesignadasH t WHERE t.cdTipoOperacao = :cdTipoOperacao"),
		@NamedQuery(name = "Tth001JOperNaoDesignadasH.findByDsTipoOperacao", query = "SELECT t FROM Tth001JOperNaoDesignadasH t WHERE t.dsTipoOperacao = :dsTipoOperacao"),
		@NamedQuery(name = "Tth001JOperNaoDesignadasH.findByDtNegociacao", query = "SELECT t FROM Tth001JOperNaoDesignadasH t WHERE t.dtNegociacao = :dtNegociacao"),
		@NamedQuery(name = "Tth001JOperNaoDesignadasH.findByAnoSafra", query = "SELECT t FROM Tth001JOperNaoDesignadasH t WHERE t.anoSafra = :anoSafra"),
		@NamedQuery(name = "Tth001JOperNaoDesignadasH.findByMesAno", query = "SELECT t FROM Tth001JOperNaoDesignadasH t WHERE t.mesAno = :mesAno"),
		@NamedQuery(name = "Tth001JOperNaoDesignadasH.findByQtde", query = "SELECT t FROM Tth001JOperNaoDesignadasH t WHERE t.qtde = :qtde"),
		@NamedQuery(name = "Tth001JOperNaoDesignadasH.findByPreco", query = "SELECT t FROM Tth001JOperNaoDesignadasH t WHERE t.preco = :preco") })
public class Tth001JOperNaoDesignadasH implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "CONTRATO", nullable = false)
	private long contrato;
	@Column(name = "TIPO_INSTRUMENTO")
	private BigInteger tipoInstrumento;
	@Basic(optional = false)
	@Column(name = "NM_FIXACAO_TIPO", nullable = false, length = 20)
	private String nmFixacaoTipo;
	@Basic(optional = false)
	@Column(name = "CD_GRP_PRODUTO", nullable = false)
	private BigInteger cdGrpProduto;
	@Basic(optional = false)
	@Column(name = "NM_GRP_PRODUTO", nullable = false, length = 20)
	private String nmGrpProduto;
	@Column(name = "CD_TIPO_OPERACAO")
	private BigInteger cdTipoOperacao;
	@Basic(optional = false)
	@Column(name = "DS_TIPO_OPERACAO", nullable = false, length = 20)
	private String dsTipoOperacao;
	@Column(name = "DT_NEGOCIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtNegociacao;
	@Column(name = "ANO_SAFRA", length = 4)
	private String anoSafra;
	@Column(name = "MES_ANO", length = 7)
	private String mesAno;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "QTDE", precision = 18, scale = 4)
	private BigDecimal qtde;
	@Column(name = "PRECO", precision = 25, scale = 6)
	private BigDecimal preco;

	public Tth001JOperNaoDesignadasH() {
	}

	public long getContrato() {
		return contrato;
	}

	public void setContrato(long contrato) {
		this.contrato = contrato;
	}

	public BigInteger getTipoInstrumento() {
		return tipoInstrumento;
	}

	public void setTipoInstrumento(BigInteger tipoInstrumento) {
		this.tipoInstrumento = tipoInstrumento;
	}

	public String getNmFixacaoTipo() {
		return nmFixacaoTipo;
	}

	public void setNmFixacaoTipo(String nmFixacaoTipo) {
		this.nmFixacaoTipo = nmFixacaoTipo;
	}

	public BigInteger getCdGrpProduto() {
		return cdGrpProduto;
	}

	public void setCdGrpProduto(BigInteger cdGrpProduto) {
		this.cdGrpProduto = cdGrpProduto;
	}

	public String getNmGrpProduto() {
		return nmGrpProduto;
	}

	public void setNmGrpProduto(String nmGrpProduto) {
		this.nmGrpProduto = nmGrpProduto;
	}

	public BigInteger getCdTipoOperacao() {
		return cdTipoOperacao;
	}

	public void setCdTipoOperacao(BigInteger cdTipoOperacao) {
		this.cdTipoOperacao = cdTipoOperacao;
	}

	public String getDsTipoOperacao() {
		return dsTipoOperacao;
	}

	public void setDsTipoOperacao(String dsTipoOperacao) {
		this.dsTipoOperacao = dsTipoOperacao;
	}

	public Date getDtNegociacao() {
		return dtNegociacao;
	}

	public void setDtNegociacao(Date dtNegociacao) {
		this.dtNegociacao = dtNegociacao;
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

	public BigDecimal getQtde() {
		return qtde;
	}

	public void setQtde(BigDecimal qtde) {
		this.qtde = qtde;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
