package Logbuch;

import java.util.ArrayList;
import java.util.Arrays;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "Logbuch")
@ApplicationScoped
public class Logbuch {
    
    private ArrayList<LogbuchEintrag> eintraege = new ArrayList<>(Arrays.asList(
            new LogbuchEintrag("10:15", "ost", "schnell", "süd", "???", LogbuchEintrag.Motorstatus.aus)
    ));

    public ArrayList<LogbuchEintrag> getEintraege() {
        System.out.println(eintraege.size() + " Einträge angefordert");
        return eintraege;
    }

    public void setEintraege(ArrayList<LogbuchEintrag> eintraege) {
        this.eintraege = eintraege;
    }
    
}
