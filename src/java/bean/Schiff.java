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
@Table(name = "schiff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schiff.findAll", query = "SELECT s FROM Schiff s")
    , @NamedQuery(name = "Schiff.findBySchiffId", query = "SELECT s FROM Schiff s WHERE s.schiffId = :schiffId")
    , @NamedQuery(name = "Schiff.findBySLatitude", query = "SELECT s FROM Schiff s WHERE s.sLatitude = :sLatitude")
    , @NamedQuery(name = "Schiff.findBySLongitude", query = "SELECT s FROM Schiff s WHERE s.sLongitude = :sLongitude")})
public class Schiff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "schiff_id")
    private Integer schiffId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "s_latitude")
    private Double sLatitude;
    @Column(name = "s_longitude")
    private Double sLongitude;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "schiff")
    private Regatta regatta;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "schiff")
    private Crew crew;
    @JoinColumn(name = "schiff_id", referencedColumnName = "benutzer_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Benutzer benutzer;
    @JoinColumn(name = "schiff_id", referencedColumnName = "schiffstyp_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Schiffstyp schiffstyp;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "schiff")
    private Route route;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "schiff")
    private Bestand bestand;

    public Schiff() {
    }

    public Schiff(Integer schiffId) {
        this.schiffId = schiffId;
    }

    public Integer getSchiffId() {
        return schiffId;
    }

    public void setSchiffId(Integer schiffId) {
        this.schiffId = schiffId;
    }

    public Double getSLatitude() {
        return sLatitude;
    }

    public void setSLatitude(Double sLatitude) {
        this.sLatitude = sLatitude;
    }

    public Double getSLongitude() {
        return sLongitude;
    }

    public void setSLongitude(Double sLongitude) {
        this.sLongitude = sLongitude;
    }

    public Regatta getRegatta() {
        return regatta;
    }

    public void setRegatta(Regatta regatta) {
        this.regatta = regatta;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public Schiffstyp getSchiffstyp() {
        return schiffstyp;
    }

    public void setSchiffstyp(Schiffstyp schiffstyp) {
        this.schiffstyp = schiffstyp;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Bestand getBestand() {
        return bestand;
    }

    public void setBestand(Bestand bestand) {
        this.bestand = bestand;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schiffId != null ? schiffId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schiff)) {
            return false;
        }
        Schiff other = (Schiff) object;
        if ((this.schiffId == null && other.schiffId != null) || (this.schiffId != null && !this.schiffId.equals(other.schiffId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Schiff[ schiffId=" + schiffId + " ]";
    }
    
}
