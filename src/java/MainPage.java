import javax.faces.bean.ManagedBean;


@ManagedBean
public class MainPage {
    
    private boolean isLog = false;
    private boolean isAbm = true;
    
    public boolean getIsLog(){
        return isLog;
    }
    public void setIsLog(boolean logStat){
        isLog = logStat;
    }
    public boolean getIsAbm(){
        return isAbm;
    }
    public void setIsAbm(boolean logStat){
        isAbm = logStat;
    }
    
    public void abmeldeListener(){
        setIsLog(true);
        setIsAbm(false);
    }

}
