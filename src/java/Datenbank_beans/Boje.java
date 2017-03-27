/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datenbank_beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    , @NamedQuery(name = "Boje.findByBojeId", query = "SELECT b FROM Boje b WHERE b.bojeId = :bojeId")})
public class Boje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "boje_id")
    private Integer bojeId;

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
