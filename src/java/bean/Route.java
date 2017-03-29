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
import javax.persistence.JoinColumn;
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
@Table(name = "route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r")
    , @NamedQuery(name = "Route.findByRouteId", query = "SELECT r FROM Route r WHERE r.routeId = :routeId")
    , @NamedQuery(name = "Route.findByRoutenname", query = "SELECT r FROM Route r WHERE r.routenname = :routenname")})
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "route_id")
    private Integer routeId;
    @Column(name = "routenname")
    private Integer routenname;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "route")
    private Wegpunkte wegpunkte;
    @JoinColumn(name = "route_id", referencedColumnName = "schiff_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Schiff schiff;

    public Route() {
    }

    public Route(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getRoutenname() {
        return routenname;
    }

    public void setRoutenname(Integer routenname) {
        this.routenname = routenname;
    }

    public Wegpunkte getWegpunkte() {
        return wegpunkte;
    }

    public void setWegpunkte(Wegpunkte wegpunkte) {
        this.wegpunkte = wegpunkte;
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
        hash += (routeId != null ? routeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.routeId == null && other.routeId != null) || (this.routeId != null && !this.routeId.equals(other.routeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Route[ routeId=" + routeId + " ]";
    }
    
}
