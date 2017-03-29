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
@Table(name = "benutzer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Benutzer.findAll", query = "SELECT b FROM Benutzer b")
    , @NamedQuery(name = "Benutzer.findByBenutzerId", query = "SELECT b FROM Benutzer b WHERE b.benutzerId = :benutzerId")
    , @NamedQuery(name = "Benutzer.findByUsername", query = "SELECT b FROM Benutzer b WHERE b.username = :username")
    , @NamedQuery(name = "Benutzer.findByPasswort", query = "SELECT b FROM Benutzer b WHERE b.passwort = :passwort")
    , @NamedQuery(name = "Benutzer.findByStatus", query = "SELECT b FROM Benutzer b WHERE b.status = :status")})
public class Benutzer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "benutzer_id")
    private Integer benutzerId;
    @Size(max = 2147483647)
    @Column(name = "username")
    private String username;
    @Size(max = 2147483647)
    @Column(name = "passwort")
    private String passwort;
    @Column(name = "status")
    private Boolean status;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "benutzer")
    private Schiff schiff;

    public Benutzer() {
    }

    public Benutzer(Integer benutzerId) {
        this.benutzerId = benutzerId;
    }

    public Integer getBenutzerId() {
        return benutzerId;
    }

    public void setBenutzerId(Integer benutzerId) {
        this.benutzerId = benutzerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        hash += (benutzerId != null ? benutzerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Benutzer)) {
            return false;
        }
        Benutzer other = (Benutzer) object;
        if ((this.benutzerId == null && other.benutzerId != null) || (this.benutzerId != null && !this.benutzerId.equals(other.benutzerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Benutzer[ benutzerId=" + benutzerId + " ]";
    }
    
}
