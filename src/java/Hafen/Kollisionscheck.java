/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hafen;
import java.awt.Polygon;

/**
 *
 * @author natascharis
 */
public class Kollisionscheck {
    
    private Polygon polygon;
    
    
    
    public boolean checkCollision(GeoPosition position){
        
        if(this.polygon==null){
            return false;
        }//check if null 
        
      return polygon.contains((double)position.getLat(),(double)position.getLong());
    }
    public void setPolygon(Polygon polygon){
        this.polygon=polygon; 
        
      
    }
    public static void main (String [] args){
        Kollisionscheck check =new Kollisionscheck();
        GeoPosition position=new GeoPosition(3F,3F);
        Polygon p=new Polygon();
        p.addPoint(0,0);
        p.addPoint(5, 0);
        p.addPoint(5, 5);
        p.addPoint(0, 5);
        check.setPolygon(p);
        System.out.println(check.checkCollision(position));
      
    }
}
