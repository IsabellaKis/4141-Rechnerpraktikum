/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motorsteuerung;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SlideEndEvent;

/**
 *
 * @author h0253115
 */
@ManagedBean
public class SliderView {
//auf double aendern wahrscheinlich

    private int number1;
    private int number2;
    private int number3;
    private int number4;
    private int number5;
    private String number6;

    
    public int getNumber1() {
        System.out.println("Antriebsstärke: " + number1);
        return number1;
    }

    public void setNumber1(int number1) {
        // System.out.println("Hallo Setter number 1");
        this.number1 = number1;
    }

    public int getNumber2() {
        System.out.println("Ruder: " + number2);
        return number2;
    }

    public void setNumber2(int number2) {
        //System.out.println("Hallo Setter number 2");
        this.number2 = number2;
    }

    public int getNumber3() {
        System.out.println("Baum: " + number3);
        return number3;
    }

    public void setNumber3(int number3) {
        //System.out.println("Hallo Setter number 3");
        this.number3 = number3;
    }

    public int getNumber4() {
        System.out.println("Reff: " + number4);
        return number4;
    }

    public void setNumber4(int number4) {
        //System.out.println("Hallo Setter number 4 ");
        this.number4 = number4;
    }

    public int getNumber5() {
        String power ="Aus" ;
       if (number5 == 100) {power = "Ein";}
        else power = "Aus";
        System.out.println("Power: " + power);
        return number5;
    }

    public void setNumber5(int number5) {
        //System.out.println("Hallo Setter number 5");
        String power ="Aus" ;
       
        
        
       System.out.println("Power: " + power);
          if (number5 == 100) {number6 = "Ein";}
        else  {number6 = "Aus";}
       
       
       this.number5 = number5;
       
        
        
        //this.number5 = number5;
    }

    public void onSlideEnd(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Slide Ended", "Value: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
