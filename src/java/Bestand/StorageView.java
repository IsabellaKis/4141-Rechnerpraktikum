package Bestand;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import entities.Artikel;
import java.util.ArrayList;
 
@ManagedBean(name="StorageView")
@ViewScoped
public class StorageView implements Serializable {
     
    public List<Artikel> lager;
    public String art;
    public int vorrat;
    public String einheit;
    public double preis;
    
    int verbrauchInterval;
        
    @PostConstruct
    public void init() {
        lager = new ArrayList<Artikel>();
        
        String[] artNamen = {"Apfel", "Brot", "Kartoffel", "Reis", "Käse", "Butter", "Schinken", "Müsli", "Marmelade", "Fisch", "Trinkwasser", "Milch", "Bier", "Wein", "Apfelsaft", "Orangensaft", "Rettungsweste", "Decke", "Kissen"};
        int[] stueck = {100, 90, 200, 150, 40, 10, 40, 100, 6, 120, 600, 200, 2, 200, 100, 100, 30, 40, 40};
        String[] artEinheit = {"kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "kg", "l", "l", "l", "l", "l", "l", "Stk", "Stk", "Stk"};  
        double[] preis = {1.99, 3.11, 4.20, 1.25, 4.10, 1.10, 3.70, 4.00, 4,30, 6.30, 1.00, 3.40, 7.80, 1.90, 1.90, 110.00, 30.00, 5.00, 110.00, 30.00, 5.00};
        for (int i = 0; i < artNamen.length; i++) {
            lager.add(createArtikel(artNamen[i], stueck[i], artEinheit[i], preis[i]));
            
        }
                   
        verbrauchInterval = 60; //alle xx Sekunden
    }
    
    public void setArt(String art) {
        this.art = art;
    }
    public String getArt() {
        return this.art;
    }
    
    public void setEinheit(String einheit) {
        this.einheit = einheit;
    }
    public String getEinheit() {
        return this.einheit;
    }
    
    public void setVorrat(int vorrat) {
        this.vorrat = vorrat;
    }
    public int getVorrat() {
        return this.vorrat;
    }
    
    public void setPreis(double preis) {
        this.preis = preis;
    }
    public double getPreis() {
        return this.preis;
    }
    
    public void setVerbrauchInterval(int verbrauchInterval) {
        this.verbrauchInterval = verbrauchInterval;
    }
    
    public int getVerbrauchInterval() {
        return this.verbrauchInterval;
    }
    
       
    public void addItem() {
        lager.add(createArtikel(art, vorrat, einheit, preis));
    }
    /*
    
    
    */
    public Artikel createArtikel(String name, int stueck, String einheit, double preis) {
        Artikel artikelNeu;
        artikelNeu = new Artikel();
        
        artikelNeu.setId(lager.size() + 1);
        artikelNeu.setName(name);
        artikelNeu.setVorrat(stueck);
        artikelNeu.setEinheit(einheit);
        artikelNeu.setPreis(preis);
        
        //Meine Vermutung: Hier die Methode zum Hinzufügen in DB aufrufen
        
        return artikelNeu;
    }
    
    public List<Artikel> getLager() {
        return lager;
    }
    
    public double getGesamt(int stueck, double preis) {
        return stueck*preis;
    }
    
    public void verbrauch() {   
        
        
        for(Artikel a : lager) {
            if("Bier".equals(a.getName())) {
                if(a.getVorrat() > 0) {
                    a.setVorrat(a.getVorrat() - 1);

                    FacesMessage msg = new FacesMessage("Verbrauch von Bier");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage("Kein Bier mehr vorhanden");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
                    
            }
        }
    }
    
        
    public void onRowEdit(RowEditEvent event) {
        Artikel changedArtikel = (Artikel) event.getObject(); //geänderter Artikel 
        
        //Meine Vermutung: Hier die Methode zum Ändern auf DB aufrufen
        
        FacesMessage msg = new FacesMessage("Bestand Edited (id: " + changedArtikel.getId() + ")");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
     
    public void onRowCancel(RowEditEvent event) {
        int id = ((Artikel) event.getObject()).getId();
        
        FacesMessage msg = new FacesMessage("Bestand Cancelled (id: " + id + ")");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
}
