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
@Table(name = "crewmember")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Crewmember.findAll", query = "SELECT c FROM Crewmember c")
    , @NamedQuery(name = "Crewmember.findByPassnummer", query = "SELECT c FROM Crewmember c WHERE c.passnummer = :passnummer")
    , @NamedQuery(name = "Crewmember.findByVorname", query = "SELECT c FROM Crewmember c WHERE c.vorname = :vorname")
    , @NamedQuery(name = "Crewmember.findByNachname", query = "SELECT c FROM Crewmember c WHERE c.nachname = :nachname")
    , @NamedQuery(name = "Crewmember.findByAufgabenbereich", query = "SELECT c FROM Crewmember c WHERE c.aufgabenbereich = :aufgabenbereich")})
public class Crewmember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "passnummer")
    private Integer passnummer;
    @Size(max = 2147483647)
    @Column(name = "vorname")
    private String vorname;
    @Size(max = 2147483647)
    @Column(name = "nachname")
    private String nachname;
    @Size(max = 2147483647)
    @Column(name = "aufgabenbereich")
    private String aufgabenbereich;
    @JoinColumn(name = "passnummer", referencedColumnName = "crew_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Crew crew;

    public Crewmember() {
    }

    public Crewmember(Integer passnummer) {
        this.passnummer = passnummer;
    }

    public Integer getPassnummer() {
        return passnummer;
    }

    public void setPassnummer(Integer passnummer) {
        this.passnummer = passnummer;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getAufgabenbereich() {
        return aufgabenbereich;
    }

    public void setAufgabenbereich(String aufgabenbereich) {
        this.aufgabenbereich = aufgabenbereich;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (passnummer != null ? passnummer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Crewmember)) {
            return false;
        }
        Crewmember other = (Crewmember) object;
        if ((this.passnummer == null && other.passnummer != null) || (this.passnummer != null && !this.passnummer.equals(other.passnummer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Crewmember[ passnummer=" + passnummer + " ]";
    }
    
}
