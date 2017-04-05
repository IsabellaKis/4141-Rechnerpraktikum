package Logbuch;

public class LogbuchEintrag {

    public String getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(String uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

    public String getWindrichtung() {
        return windrichtung;
    }

    public void setWindrichtung(String windrichtung) {
        this.windrichtung = windrichtung;
    }

    public String getWindgeschwindigkeit() {
        return windgeschwindigkeit;
    }

    public void setWindgeschwindigkeit(String windgeschwindigkeit) {
        this.windgeschwindigkeit = windgeschwindigkeit;
    }

    public String getKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }

    public String getSegelfuehrung() {
        return segelfuehrung;
    }

    public void setSegelfuehrung(String segelfuehrung) {
        this.segelfuehrung = segelfuehrung;
    }

    public Motorstatus getMotor() {
        return motor;
    }

    public void setMotor(Motorstatus motor) {
        this.motor = motor;
    }

    public LogbuchEintrag(String uhrzeit, String windrichtung, String windgeschwindigkeit, String kurs, String segelfuehrung, Motorstatus motor) {
        this.uhrzeit = uhrzeit;
        this.windrichtung = windrichtung;
        this.windgeschwindigkeit = windgeschwindigkeit;
        this.kurs = kurs;
        this.segelfuehrung = segelfuehrung;
        this.motor = motor;
    }

    public enum Motorstatus {an, aus};
    
    String uhrzeit;
    String windrichtung;
    String windgeschwindigkeit;
    String kurs;
    String segelfuehrung;
    Motorstatus motor;
    
}
