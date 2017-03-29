/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author h1451938
 */
@Entity
@Table(name = "bestand")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bestand.findAll", query = "SELECT b FROM Bestand b")
    , @NamedQuery(name = "Bestand.findByBestandId", query = "SELECT b FROM Bestand b WHERE b.bestandId = :bestandId")
    , @NamedQuery(name = "Bestand.findByStueck", query = "SELECT b FROM Bestand b WHERE b.stueck = :stueck")
    , @NamedQuery(name = "Bestand.findByEinheit", query = "SELECT b FROM Bestand b WHERE b.einheit = :einheit")
    , @NamedQuery(name = "Bestand.findByPreis", query = "SELECT b FROM Bestand b WHERE b.preis = :preis")})
public class Bestand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bestand_id")
    private Integer bestandId;
    @Column(name = "stueck")
    private Integer stueck;
    @Size(max = 2147483647)
    @Column(name = "einheit")
    private String einheit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preis")
    private Double preis;
    @JoinColumn(name = "bestand_id", referencedColumnName = "artikel_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Artikel artikel;
    @JoinColumn(name = "bestand_id", referencedColumnName = "schiff_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Schiff schiff;

    public Bestand() {
    }

    public Bestand(Integer bestandId) {
        this.bestandId = bestandId;
    }

    public Integer getBestandId() {
        return bestandId;
    }

    public void setBestandId(Integer bestandId) {
        this.bestandId = bestandId;
    }

    public Integer getStueck() {
        return stueck;
    }

    public void setStueck(Integer stueck) {
        this.stueck = stueck;
    }

    public String getEinheit() {
        return einheit;
    }

    public void setEinheit(String einheit) {
        this.einheit = einheit;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
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
        hash += (bestandId != null ? bestandId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bestand)) {
            return false;
        }
        Bestand other = (Bestand) object;
        if ((this.bestandId == null && other.bestandId != null) || (this.bestandId != null && !this.bestandId.equals(other.bestandId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Bestand[ bestandId=" + bestandId + " ]";
    }
    
}
