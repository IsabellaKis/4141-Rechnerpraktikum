
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;



@ManagedBean
public class LoginCode {
    
    private String app = "Werft";
    
    public void buttonAction(String benutzername, String passwort) {
        sampletextWarn();
        
        //toDo oben löschen
        //toDo benutzername && passwort mit datenbank vergleichen falls nicht vorhanden dann fehlermeldung
        //toDo falls ok dann je nach status von app weiterleiten
    }
    public void onAppChange() {
        if(app.equals("Werft")) setApp("Fahrten");
        else setApp("Werft");
    }
    
    public void setApp(String a){
        app = a;
    }
    public String getApp(){
        return app;
    }
    public void sampletextWarn() {
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Achtung!", app));
    }
}
