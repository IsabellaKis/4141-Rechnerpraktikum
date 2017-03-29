package ClientframeworkLogin;


import javax.faces.bean.ManagedBean;

import Schiff.*;

@ManagedBean
public class MainPage {

    private static boolean isLog = false;
    private static boolean isAbm = true;
    //private Schiff s = new Schiff();
    //private schiffSimulation schiffSim = new schiffSimulation();
    private static String panelHeader = "Werft/Fahrten";

    public void abmeldeListener() {
        setIsLog(true);
        setIsAbm(false);

        //Token auf false setzen schiffSimulation
        // schiffSim.initialisiere();
    }

    public boolean getIsLog() {
        return isLog;
    }

    public void setIsLog(boolean logStat) {
        isLog = logStat;
    }

    public boolean getIsAbm() {
        return isAbm;
    }

    public void setIsAbm(boolean logStat) {
        isAbm = logStat;
    }

    /*public Schiff getS() {
        return s;
    }
    public void setS(Schiff s) {
        this.s = s;
    }
    public schiffSimulation getSchiffSim() {
        return schiffSim;
    }
    public void setSchiffSim(schiffSimulation schiffSim) {
        this.schiffSim = schiffSim;
    }
     */
    public String getPanelHeader() {
        return panelHeader;
    }

    public void setPanelHeader(String panelHeader) {
        this.panelHeader = panelHeader;
    }

    public String werftOrFahrten(){
        
        if(panelHeader.equals("Werft Applikation")){
            return "maschine.xhtml";
        }
        else if(panelHeader.equals("Fahrten Applikation")){
            return "registPage.xhtml";
        }
        else{
            return null;
        }
    }
}
