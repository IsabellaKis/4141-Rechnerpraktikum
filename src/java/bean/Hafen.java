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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author h1451938
 */
@Entity
@Table(name = "hafen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hafen.findAll", query = "SELECT h FROM Hafen h")
    , @NamedQuery(name = "Hafen.findByHafenId", query = "SELECT h FROM Hafen h WHERE h.hafenId = :hafenId")
    , @NamedQuery(name = "Hafen.findByName", query = "SELECT h FROM Hafen h WHERE h.name = :name")})
public class Hafen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "hafen_id")
    private Integer hafenId;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "hafen")
    private Hafeneckpunkt hafeneckpunkt;

    public Hafen() {
    }

    public Hafen(Integer hafenId) {
        this.hafenId = hafenId;
    }

    public Integer getHafenId() {
        return hafenId;
    }

    public void setHafenId(Integer hafenId) {
        this.hafenId = hafenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hafeneckpunkt getHafeneckpunkt() {
        return hafeneckpunkt;
    }

    public void setHafeneckpunkt(Hafeneckpunkt hafeneckpunkt) {
        this.hafeneckpunkt = hafeneckpunkt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hafenId != null ? hafenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hafen)) {
            return false;
        }
        Hafen other = (Hafen) object;
        if ((this.hafenId == null && other.hafenId != null) || (this.hafenId != null && !this.hafenId.equals(other.hafenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Hafen[ hafenId=" + hafenId + " ]";
    }
    
}
