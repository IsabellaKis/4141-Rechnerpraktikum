/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wetter;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author h1550873
 */

@Named(value="Wetterdaten")
@SessionScoped
public class Wetterdaten implements Serializable {
    
        

        private double lon = (double) ((Math.random()*1)+16);
        private double lat = (double) ((Math.random()*1)+43);
        private int vmg = (int)((Math.random()*40)+1);
        private int direction = (int) ((Math.random()*360)+1);
        private int temperatur = (int) ((Math.random()*20)+10);
        private int luftdruck = (int) ((Math.random()*27)+1013);
        private int speed = (int) ((Math.random()*40)+1);

    public int getSpeed() {
        return speed = (int) ((Math.random()*40)+1);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getLon() {
        return lon=(double) ((Math.random()*1)+16);     
    }
    
    public double getLongitude() {
        return lon=(double) ((Math.random()*1)+16);     
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat = (double) ((Math.random()*1)+43);
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getVmg() {
        return vmg = (int)((Math.random()*40)+1);
    }

    public void setVmg(int vmg) {
        this.vmg = vmg;
    }

    public int getDirection() {
        return direction = (int) ((Math.random()*360)+1);
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getLuftdruck() {
        return luftdruck = (int) ((Math.random()*12)+1013);
    }

    public void setLuftdruck(int luftdruck) {
        this.luftdruck = luftdruck;
    }

    public int getTemperatur() {
        return temperatur = (int) ((Math.random()*20)+10);
    }

    public void setTemperatur(int temperatur) {
        this.temperatur = temperatur;
    }
    
    
}
