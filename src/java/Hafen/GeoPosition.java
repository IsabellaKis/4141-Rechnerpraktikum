/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hafen;

/**
 *
 * @author natascharis
 */
public class GeoPosition {
    
    private float laengengrad;
    private float breitengrad; 
    
    public float getLat(){
        return laengengrad;
    }
    
    public float getLong(){
        return breitengrad; 
    }
    
    public GeoPosition(float x,float y){
        laengengrad=x;
        breitengrad=y; 
    }
 
}
