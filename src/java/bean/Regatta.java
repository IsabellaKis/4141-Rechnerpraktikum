/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author h1451938
 */
@Entity
@Table(name = "regatta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regatta.findAll", query = "SELECT r FROM Regatta r")
    , @NamedQuery(name = "Regatta.findByRegattaId", query = "SELECT r FROM Regatta r WHERE r.regattaId = :regattaId")
    , @NamedQuery(name = "Regatta.findByPreisgeld", query = "SELECT r FROM Regatta r WHERE r.preisgeld = :preisgeld")
    , @NamedQuery(name = "Regatta.findByEnddatum", query = "SELECT r FROM Regatta r WHERE r.enddatum = :enddatum")
    , @NamedQuery(name = "Regatta.findByStartdatum", query = "SELECT r FROM Regatta r WHERE r.startdatum = :startdatum")
    , @NamedQuery(name = "Regatta.findByOrt", query = "SELECT r FROM Regatta r WHERE r.ort = :ort")})
public class Regatta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "regatta_id")
    private Integer regattaId;
    @Column(name = "preisgeld")
    private Integer preisgeld;
    @Column(name = "enddatum")
    @Temporal(TemporalType.DATE)
    private Date enddatum;
    @Column(name = "startdatum")
    @Temporal(TemporalType.DATE)
    private Date startdatum;
    @Size(max = 2147483647)
    @Column(name = "ort")
    private String ort;
    @JoinColumn(name = "regatta_id", referencedColumnName = "boje_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Boje boje;
    @JoinColumn(name = "regatta_id", referencedColumnName = "schiff_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Schiff schiff;

    public Regatta() {
    }

    public Regatta(Integer regattaId) {
        this.regattaId = regattaId;
    }

    public Integer getRegattaId() {
        return regattaId;
    }

    public void setRegattaId(Integer regattaId) {
        this.regattaId = regattaId;
    }

    public Integer getPreisgeld() {
        return preisgeld;
    }

    public void setPreisgeld(Integer preisgeld) {
        this.preisgeld = preisgeld;
    }

    public Date getEnddatum() {
        return enddatum;
    }

    public void setEnddatum(Date enddatum) {
        this.enddatum = enddatum;
    }

    public Date getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(Date startdatum) {
        this.startdatum = startdatum;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Boje getBoje() {
        return boje;
    }

    public void setBoje(Boje boje) {
        this.boje = boje;
    }

    public Schiff getSchiff() {
        return schiff;
    }

    public void setSchiff(Schiff schiff) {
        this.schiff = schiff;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regattaId != null ? regattaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regatta)) {
            return false;
        }
        Regatta other = (Regatta) object;
        if ((this.regattaId == null && other.regattaId != null) || (this.regattaId != null && !this.regattaId.equals(other.regattaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Regatta[ regattaId=" + regattaId + " ]";
    }
    
}
