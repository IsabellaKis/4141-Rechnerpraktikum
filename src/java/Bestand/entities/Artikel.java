package entities;

import java.io.Serializable;
import javax.persistence.Entity;
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
    
    /*public String toString() {
        return "entities.Artikel[ vorrat=" + vorrat + " ]";
    }*/
    
    public int getVorrat() {
        return vorrat;
    }
    
    public void setVorrat(int vorrat) {
        this.vorrat = vorrat;
    }

       
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
