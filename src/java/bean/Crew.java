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
@Table(name = "crew")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Crew.findAll", query = "SELECT c FROM Crew c")
    , @NamedQuery(name = "Crew.findByCrewId", query = "SELECT c FROM Crew c WHERE c.crewId = :crewId")})
public class Crew implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "crew_id")
    private Integer crewId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "crew")
    private Crewmember crewmember;
    @JoinColumn(name = "crew_id", referencedColumnName = "schiff_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Schiff schiff;

    public Crew() {
    }

    public Crew(Integer crewId) {
        this.crewId = crewId;
    }

    public Integer getCrewId() {
        return crewId;
    }

    public void setCrewId(Integer crewId) {
        this.crewId = crewId;
    }

    public Crewmember getCrewmember() {
        return crewmember;
    }

    public void setCrewmember(Crewmember crewmember) {
        this.crewmember = crewmember;
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
        hash += (crewId != null ? crewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Crew)) {
            return false;
        }
        Crew other = (Crew) object;
        if ((this.crewId == null && other.crewId != null) || (this.crewId != null && !this.crewId.equals(other.crewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Crew[ crewId=" + crewId + " ]";
    }
    
}
