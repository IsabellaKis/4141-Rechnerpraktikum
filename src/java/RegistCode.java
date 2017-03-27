import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
public class RegistCode {
 
    String labelName="hhhhhh";
    boolean editMode=false;
    private String password5;
    
    
    public void buttonAction(String benutzername, String passwort, String passwortWdh) {
        labelName=benutzername;
        editMode=true;
        setName();
        setEditMode();
        
        if(!passwort.equals(passwortWdh)){
        passwortWarn();
            }
        
        }
        //toDo das von oben löschen
        //toDo benutzername checken falls != datenbank dann ok sonst fehlermeldung
        //toDo passwort mit passwortwdh prüfen falls gleich dann ok sonst fehlermeldung
    
    public String setName(){
        return labelName;
    }
    public boolean setEditMode(){
        return editMode;
    }
    public void passwortWarn() {
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Achtung!", "Passwörter stimmen nicht überein"));
    }
    public void benutzernameWarn() {
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Achtung!", "Benutzername bereits vergeben"));
    }
    

}
