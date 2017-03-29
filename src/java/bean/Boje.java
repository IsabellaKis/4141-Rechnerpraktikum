/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author h1451938
 */
@Entity
@Table(name = "boje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boje.findAll", query = "SELECT b FROM Boje b")
    , @NamedQuery(name = "Boje.findByBojeId", query = "SELECT b FROM Boje b WHERE b.bojeId = :bojeId")
    , @NamedQuery(name = "Boje.findByBLatitude", query = "SELECT b FROM Boje b WHERE b.bLatitude = :bLatitude")
    , @NamedQuery(name = "Boje.findByBLongitude", query = "SELECT b FROM Boje b WHERE b.bLongitude = :bLongitude")})
public class Boje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "boje_id")
    private Integer bojeId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "b_latitude")
    private Double bLatitude;
    @Column(name = "b_longitude")
    private Double bLongitude;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "boje")
    private Regatta regatta;

    public Boje() {
    }

    public Boje(Integer bojeId) {
        this.bojeId = bojeId;
    }

    public Integer getBojeId() {
        return bojeId;
    }

    public void setBojeId(Integer bojeId) {
        this.bojeId = bojeId;
    }

    public Double getBLatitude() {
        return bLatitude;
    }

    public void setBLatitude(Double bLatitude) {
        this.bLatitude = bLatitude;
    }

    public Double getBLongitude() {
        return bLongitude;
    }

    public void setBLongitude(Double bLongitude) {
        this.bLongitude = bLongitude;
    }

    public Regatta getRegatta() {
        return regatta;
    }

    public void setRegatta(Regatta regatta) {
        this.regatta = regatta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bojeId != null ? bojeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boje)) {
            return false;
        }
        Boje other = (Boje) object;
        if ((this.bojeId == null && other.bojeId != null) || (this.bojeId != null && !this.bojeId.equals(other.bojeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Boje[ bojeId=" + bojeId + " ]";
    }
    
}
