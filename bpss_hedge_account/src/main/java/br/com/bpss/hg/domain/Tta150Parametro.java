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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "TTA150_PARAMETRO", catalog = "", schema = "HEDGE_AGRARIA")
@NamedQueries({
    @NamedQuery(name = "Tta150Parametro.findAll", query = "SELECT t FROM Tta150Parametro t"),
})
public class Tta150Parametro implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Tta150ParametroPK tta150ParametroPK;
    @Column(name = "DT_VM_ULTIMA_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtVmUltimaAtualizacao;
    @Basic(optional = false)
    @Column(name = "ANO_SAFRA_POSTERIOR", nullable = false, length = 4)
    private String anoSafraPosterior;
    @Basic(optional = false)
    @Column(name = "ANO_SAFRA_ATUAL", nullable = false, length = 4)
    private String anoSafraAtual;
    @Basic(optional = false)
    @Column(name = "ANO_SAFRA_ANTERIOR", nullable = false, length = 4)
    private String anoSafraAnterior;
    @Column(name = "DT_VIRADA_SAFRA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtViradaSafra;
    @Column(name = "AMBIENTE", length = 20)
    private String ambiente;
    @Column(name = "VERSAO_SISTEMA", length = 40)
    private String versaoSistema;
    @Column(name = "DH_ATUAL_COTACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dhAtualCotacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "INTERPOLAR_PTAX", precision = 30, scale = 20)
    private BigDecimal interpolarPtax;
    @Column(name = "NR_DIAS")
    private BigInteger nrDias;
    @Column(name = "DT_INTERP_MANUAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInterpManual;
    @Column(name = "FL_EXP_CAMBIAL")
    private Character flExpCambial;
    @Column(name = "VERSAO", length = 20)
    private String versao;
    @Column(name = "FL_VERSAO_CLIENTE")
    private Character flVersaoCliente;
    @Column(name = "FL_CONF_EMAIL")
    private Character flConfEmail;
    @Column(name = "ID_SAF_ATUAL")
    private Long idSafAtual;
    @Column(name = "ID_SAF_POST")
    private Long idSafPost;
    @Column(name = "FL_GERA_BI")
    private Character flGeraBi;
    @Column(name = "DT_ESM_SAF_POSTERIOR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEsmSafPosterior;
    @Column(name = "DT_ESM_SAF_ATUAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEsmSafAtual;
    @Column(name = "DT_ESM_SAF_ANTERIOR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEsmSafAnterior;
    @Column(name = "MES_ANO_APURACAO", length = 6)
    private String mesAnoApuracao;
    @Column(name = "DT_CARGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCarga;
    @Column(name = "FL_STATUS_CARGA")
    private Character flStatusCarga;
    @Column(name = "FL_STATUS_CALCULO")
    private Character flStatusCalculo;
    @Column(name = "DT_CALCULO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCalculo;

    public Tta150Parametro() {
    }

    public Tta150Parametro(Tta150ParametroPK tta150ParametroPK) {
        this.tta150ParametroPK = tta150ParametroPK;
    }

    public Tta150Parametro(Tta150ParametroPK tta150ParametroPK, String anoSafraPosterior, String anoSafraAtual, String anoSafraAnterior) {
        this.tta150ParametroPK = tta150ParametroPK;
        this.anoSafraPosterior = anoSafraPosterior;
        this.anoSafraAtual = anoSafraAtual;
        this.anoSafraAnterior = anoSafraAnterior;
    }

    public Tta150Parametro(BigInteger cdParametro, String anoSafraVigente) {
        this.tta150ParametroPK = new Tta150ParametroPK(cdParametro, anoSafraVigente);
    }

    public Tta150ParametroPK getTta150ParametroPK() {
        return tta150ParametroPK;
    }

    public void setTta150ParametroPK(Tta150ParametroPK tta150ParametroPK) {
        this.tta150ParametroPK = tta150ParametroPK;
    }

    public Date getDtVmUltimaAtualizacao() {
        return dtVmUltimaAtualizacao;
    }

    public void setDtVmUltimaAtualizacao(Date dtVmUltimaAtualizacao) {
        this.dtVmUltimaAtualizacao = dtVmUltimaAtualizacao;
    }

    public String getAnoSafraPosterior() {
        return anoSafraPosterior;
    }

    public void setAnoSafraPosterior(String anoSafraPosterior) {
        this.anoSafraPosterior = anoSafraPosterior;
    }

    public String getAnoSafraAtual() {
        return anoSafraAtual;
    }

    public void setAnoSafraAtual(String anoSafraAtual) {
        this.anoSafraAtual = anoSafraAtual;
    }

    public String getAnoSafraAnterior() {
        return anoSafraAnterior;
    }

    public void setAnoSafraAnterior(String anoSafraAnterior) {
        this.anoSafraAnterior = anoSafraAnterior;
    }

    public Date getDtViradaSafra() {
        return dtViradaSafra;
    }

    public void setDtViradaSafra(Date dtViradaSafra) {
        this.dtViradaSafra = dtViradaSafra;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getVersaoSistema() {
        return versaoSistema;
    }

    public void setVersaoSistema(String versaoSistema) {
        this.versaoSistema = versaoSistema;
    }

    public Date getDhAtualCotacao() {
        return dhAtualCotacao;
    }

    public void setDhAtualCotacao(Date dhAtualCotacao) {
        this.dhAtualCotacao = dhAtualCotacao;
    }

    public BigDecimal getInterpolarPtax() {
        return interpolarPtax;
    }

    public void setInterpolarPtax(BigDecimal interpolarPtax) {
        this.interpolarPtax = interpolarPtax;
    }

    public BigInteger getNrDias() {
        return nrDias;
    }

    public void setNrDias(BigInteger nrDias) {
        this.nrDias = nrDias;
    }

    public Date getDtInterpManual() {
        return dtInterpManual;
    }

    public void setDtInterpManual(Date dtInterpManual) {
        this.dtInterpManual = dtInterpManual;
    }

    public Character getFlExpCambial() {
        return flExpCambial;
    }

    public void setFlExpCambial(Character flExpCambial) {
        this.flExpCambial = flExpCambial;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public Character getFlVersaoCliente() {
        return flVersaoCliente;
    }

    public void setFlVersaoCliente(Character flVersaoCliente) {
        this.flVersaoCliente = flVersaoCliente;
    }

    public Character getFlConfEmail() {
        return flConfEmail;
    }

    public void setFlConfEmail(Character flConfEmail) {
        this.flConfEmail = flConfEmail;
    }

    public Long getIdSafAtual() {
        return idSafAtual;
    }

    public void setIdSafAtual(Long idSafAtual) {
        this.idSafAtual = idSafAtual;
    }

    public Long getIdSafPost() {
        return idSafPost;
    }

    public void setIdSafPost(Long idSafPost) {
        this.idSafPost = idSafPost;
    }

    public Character getFlGeraBi() {
        return flGeraBi;
    }

    public void setFlGeraBi(Character flGeraBi) {
        this.flGeraBi = flGeraBi;
    }

    public Date getDtEsmSafPosterior() {
        return dtEsmSafPosterior;
    }

    public void setDtEsmSafPosterior(Date dtEsmSafPosterior) {
        this.dtEsmSafPosterior = dtEsmSafPosterior;
    }

    public Date getDtEsmSafAtual() {
        return dtEsmSafAtual;
    }

    public void setDtEsmSafAtual(Date dtEsmSafAtual) {
        this.dtEsmSafAtual = dtEsmSafAtual;
    }

    public Date getDtEsmSafAnterior() {
        return dtEsmSafAnterior;
    }

    public void setDtEsmSafAnterior(Date dtEsmSafAnterior) {
        this.dtEsmSafAnterior = dtEsmSafAnterior;
    }

    public String getMesAnoApuracao() {
        return mesAnoApuracao;
    }

    public void setMesAnoApuracao(String mesAnoApuracao) {
        this.mesAnoApuracao = mesAnoApuracao;
    }

    public Date getDtCarga() {
        return dtCarga;
    }

    public void setDtCarga(Date dtCarga) {
        this.dtCarga = dtCarga;
    }

    public Character getFlStatusCarga() {
        return flStatusCarga;
    }

    public void setFlStatusCarga(Character flStatusCarga) {
        this.flStatusCarga = flStatusCarga;
    }

    public Character getFlStatusCalculo() {
        return flStatusCalculo;
    }

    public void setFlStatusCalculo(Character flStatusCalculo) {
        this.flStatusCalculo = flStatusCalculo;
    }

    public Date getDtCalculo() {
        return dtCalculo;
    }

    public void setDtCalculo(Date dtCalculo) {
        this.dtCalculo = dtCalculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tta150ParametroPK != null ? tta150ParametroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tta150Parametro)) {
            return false;
        }
        Tta150Parametro other = (Tta150Parametro) object;
        if ((this.tta150ParametroPK == null && other.tta150ParametroPK != null) || (this.tta150ParametroPK != null && !this.tta150ParametroPK.equals(other.tta150ParametroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Tta150Parametro[ tta150ParametroPK=" + tta150ParametroPK + " ]";
    }
    
}
