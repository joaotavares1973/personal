/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bpss.hg.domain;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author HP
 */
@Embeddable
public class Tta150ParametroPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CD_PARAMETRO", nullable = false)
    private BigInteger cdParametro;
    @Basic(optional = false)
    @Column(name = "ANO_SAFRA_VIGENTE", nullable = false, length = 4)
    private String anoSafraVigente;

    public Tta150ParametroPK() {
    }

    public Tta150ParametroPK(BigInteger cdParametro, String anoSafraVigente) {
        this.cdParametro = cdParametro;
        this.anoSafraVigente = anoSafraVigente;
    }

    public BigInteger getCdParametro() {
        return cdParametro;
    }

    public void setCdParametro(BigInteger cdParametro) {
        this.cdParametro = cdParametro;
    }

    public String getAnoSafraVigente() {
        return anoSafraVigente;
    }

    public void setAnoSafraVigente(String anoSafraVigente) {
        this.anoSafraVigente = anoSafraVigente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdParametro != null ? cdParametro.hashCode() : 0);
        hash += (anoSafraVigente != null ? anoSafraVigente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tta150ParametroPK)) {
            return false;
        }
        Tta150ParametroPK other = (Tta150ParametroPK) object;
        if ((this.cdParametro == null && other.cdParametro != null) || (this.cdParametro != null && !this.cdParametro.equals(other.cdParametro))) {
            return false;
        }
        if ((this.anoSafraVigente == null && other.anoSafraVigente != null) || (this.anoSafraVigente != null && !this.anoSafraVigente.equals(other.anoSafraVigente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Tta150ParametroPK[ cdParametro=" + cdParametro + ", anoSafraVigente=" + anoSafraVigente + " ]";
    }
    
}
