package Wetterkarte;


import Wetter.Wetterdaten;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author h1550873
 */
@Named(value="ManagedBean")
@SessionScoped

public class ManagedBean implements Serializable{
    private int temperatur;
    private int luftdruck;
    private int zsmLuftdruck;
    private int STD;
    
    private double lon;
    private double lat;
    
    Wetterdaten daten = new Wetterdaten();
    
    public ManagedBean() {
        //this.temperatur=22;
        //this.luftdruck=1033;
        //this.zsmLuftdruck=1010;
        //this.STD=10;
    }
    
    //Temperatur
    public int getTemperatur() {
        return daten.getTemperatur();
    }
    
    public void setTemperatur(int temp) {
        this.temperatur=temp;
    }
    
    //Luftdruck
    public int getLuftdruck() {
        return daten.getLuftdruck();
    }
    
    public void setLuftdruck(int luftdruck) {
        this.luftdruck=luftdruck;
    }
    
    // ZSM Luftdruck
    public int getZSMLuftdruck() {
        return zsmLuftdruck;
    }
    
    public void setZSMLuftdruck(int zsmLuftdruck) {
        this.zsmLuftdruck=zsmLuftdruck;
    }
    
    //STD
    public int getSTD() {
        return STD;
    }
    
    public void setSTD(int STD) {
        this.STD=STD;
    }
    
    //Latitude
    public double getLatitude() {
        return daten.getLat();
    }
    
    public void setLatitude(int lat) {
        this.lat=lat;
    }
    
    //Longitude
    public double getLongitude() {
        return daten.getLon();
    }
    
    public void setLongitude(int lon) {
        this.lon=lon;
    }
    
    
    //Koordinaten
    
    public String getKoordinaten() {
        return this.lon + ";" + this.lat;
        
    }
    
    
  
    
    
   
    
}
