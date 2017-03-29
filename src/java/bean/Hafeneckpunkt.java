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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author h1451938
 */
@Entity
@Table(name = "hafeneckpunkt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hafeneckpunkt.findAll", query = "SELECT h FROM Hafeneckpunkt h")
    , @NamedQuery(name = "Hafeneckpunkt.findByHLatitude", query = "SELECT h FROM Hafeneckpunkt h WHERE h.hLatitude = :hLatitude")
    , @NamedQuery(name = "Hafeneckpunkt.findByHLongitude", query = "SELECT h FROM Hafeneckpunkt h WHERE h.hLongitude = :hLongitude")
    , @NamedQuery(name = "Hafeneckpunkt.findByHafeneckpunktId", query = "SELECT h FROM Hafeneckpunkt h WHERE h.hafeneckpunktId = :hafeneckpunktId")})
public class Hafeneckpunkt implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "h_latitude")
    private Double hLatitude;
    @Column(name = "h_longitude")
    private Double hLongitude;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hafeneckpunkt_id")
    private Integer hafeneckpunktId;
    @JoinColumn(name = "hafeneckpunkt_id", referencedColumnName = "hafen_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Hafen hafen;

    public Hafeneckpunkt() {
    }

    public Hafeneckpunkt(Integer hafeneckpunktId) {
        this.hafeneckpunktId = hafeneckpunktId;
    }

    public Double getHLatitude() {
        return hLatitude;
    }

    public void setHLatitude(Double hLatitude) {
        this.hLatitude = hLatitude;
    }

    public Double getHLongitude() {
        return hLongitude;
    }

    public void setHLongitude(Double hLongitude) {
        this.hLongitude = hLongitude;
    }

    public Integer getHafeneckpunktId() {
        return hafeneckpunktId;
    }

    public void setHafeneckpunktId(Integer hafeneckpunktId) {
        this.hafeneckpunktId = hafeneckpunktId;
    }

    public Hafen getHafen() {
        return hafen;
    }

    public void setHafen(Hafen hafen) {
        this.hafen = hafen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hafeneckpunktId != null ? hafeneckpunktId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hafeneckpunkt)) {
            return false;
        }
        Hafeneckpunkt other = (Hafeneckpunkt) object;
        if ((this.hafeneckpunktId == null && other.hafeneckpunktId != null) || (this.hafeneckpunktId != null && !this.hafeneckpunktId.equals(other.hafeneckpunktId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Hafeneckpunkt[ hafeneckpunktId=" + hafeneckpunktId + " ]";
    }
    
}
