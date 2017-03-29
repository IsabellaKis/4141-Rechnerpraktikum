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
@Table(name = "wegpunkte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wegpunkte.findAll", query = "SELECT w FROM Wegpunkte w")
    , @NamedQuery(name = "Wegpunkte.findByWLatitute", query = "SELECT w FROM Wegpunkte w WHERE w.wLatitute = :wLatitute")
    , @NamedQuery(name = "Wegpunkte.findByWLongitude", query = "SELECT w FROM Wegpunkte w WHERE w.wLongitude = :wLongitude")
    , @NamedQuery(name = "Wegpunkte.findByWegpunktId", query = "SELECT w FROM Wegpunkte w WHERE w.wegpunktId = :wegpunktId")})
public class Wegpunkte implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "w_latitute")
    private Double wLatitute;
    @Column(name = "w_longitude")
    private Double wLongitude;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wegpunkt_id")
    private Integer wegpunktId;
    @JoinColumn(name = "wegpunkt_id", referencedColumnName = "route_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Route route;

    public Wegpunkte() {
    }

    public Wegpunkte(Integer wegpunktId) {
        this.wegpunktId = wegpunktId;
    }

    public Double getWLatitute() {
        return wLatitute;
    }

    public void setWLatitute(Double wLatitute) {
        this.wLatitute = wLatitute;
    }

    public Double getWLongitude() {
        return wLongitude;
    }

    public void setWLongitude(Double wLongitude) {
        this.wLongitude = wLongitude;
    }

    public Integer getWegpunktId() {
        return wegpunktId;
    }

    public void setWegpunktId(Integer wegpunktId) {
        this.wegpunktId = wegpunktId;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wegpunktId != null ? wegpunktId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wegpunkte)) {
            return false;
        }
        Wegpunkte other = (Wegpunkte) object;
        if ((this.wegpunktId == null && other.wegpunktId != null) || (this.wegpunktId != null && !this.wegpunktId.equals(other.wegpunktId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Wegpunkte[ wegpunktId=" + wegpunktId + " ]";
    }
    
}
