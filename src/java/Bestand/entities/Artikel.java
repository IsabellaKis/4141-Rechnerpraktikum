/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bestand.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Christian
 */
@Entity
public class Artikel implements Serializable {

    @Id
    int id;
    String name;
    int vorrat;
    String einheit;
    double preis;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    public String getEinheit() {
        return einheit;
    }
    
    public void setEinheit(String einheit) {
        this.einheit = einheit;
    }
    
    
    
    public double getPreis() {
        return preis;
    }
    
    public void setPreis(double preis) {
        this.preis = preis;
    }
    
    
    public String toString() {
        return "entities.Artikel[ vorrat=" + vorrat + " ]";
    }
    
    public int getVorrat() {
        return vorrat;
    }
    
    public void setVorrat(int vorrat) {
        this.vorrat = vorrat;
    }

    
    
    
          
/*
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artikel)) {
            return false;
        }
        Artikel other = (Artikel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
