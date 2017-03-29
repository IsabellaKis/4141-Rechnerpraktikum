
package Schiff;


import java.util.Timer;
import java.util.TimerTask;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;




public class SchiffSimulation {
   
    public static String LOGTITLE =
            "T" +" "+"Wg"+" "+"Wr"+" "+"Rl"+" "+"Bam"+" "+"Sfr"+" "+"Rpm"+ " " + "Eon" + " " + "Adn" +" " +"Vr" +" "+"Wew"+ " " +"Swg"+ " " +"Swr"+ " " +"Ra" + " " +"Brs"+ " " +"Brb"+ " " +"Br" + " " +"Bw" + " " +"Kil"+" "+"Bug"+" "+"Sf" + " " +"Sew"+ " " +"Wm" + " " +"Sm" + " " +"Vm" + " " +"Bm" + " " +"V"  + " " +"K"  + " " +"Kn"  + " " +"Kmm"+ " " +"Km" + " " +"Am" + " "+"Kw"+" "+"Ks" + " " +"Kv" + " " +"Lat"+ " " +"Lon"+ " " +    "|";
    private int x;
    public static int count;
    Schiff s = new Schiff();
    Wetter w = new Wetter();
    Timer timer = new Timer();
    

    public void simulation()
    {
        double t_ = s.getT();
        double v_ = s.getV();
        double k_ = s.getK();
        double br_ = s.getBr();
        double lat_ = s.getLat();
        double lon_ = s.getLon();

        // Neuberechung
        //System.out.println(Double.toString(s.getT()));
        s.setT(s.getT()+1);
        s.setWg(calcWg(lat_, lon_));
        s.setWr(calcWr(lat_, lon_));
        s.setVr(calcVr(s.getLwl()));
        s.setWew(calcWew(s.getWr(), k_));
        s.setSwg(calcSwg(s.getWg(), v_, s.getWew()));
        s.setSwr(calcSwr(s.getWg(), s.getWr(), v_, k_, s.getSwg(), s.getWew()));
        s.setRa(calcRa(t_, s.getT(), v_, s.getRl()));
        s.setBrs(calcBrs(k_, s.getBam()));
        s.setBrb(calcBrb(k_, s.getBam()));
        s.setBr(calcBr(br_, s.getSwr(), s.getBrs(), s.getBrb()));
        s.setBw(calcBw(s.getK(),s.getBr()));
        s.setKil(calcKil(s.getSwr(), s.getBrs(), s.getBrb()));
        s.setBug(calcBug(s.getWew()));
        s.setSf(calcSf(s.getSfr(), s.getSfm()));
        s.setSew(calcSew(s.getBr(),s.getSwr()));
        s.setWm(calcWm(s.getWmp(), s.getSwg(),s.getSf()));
        s.setSm(calcSm(s.getSew(), s.getWm()));
        s.setMm(calcMm(s.getRpm(), s.getLm()));
        s.setVm(calcVm(s.getSm(), s.getSew(), s.getMm()));
        s.setBm(calcBm(s.getVm(), s.getVr(), v_, s.getM()));
        s.setV(calcV(v_, s.getVm(), s.getBm(), s.getT(), t_, s.getM(), s.isAdn()));
        s.setK(calcK(k_, s.getRa()));
        s.setKn(calcKn(s.getK(), s.getSwr()));
        s.setKmm(calcKmm(s.getSm(), s.getBw()));

         s.setKm(calcKm(s.getKmm(), s.getKw()));
        s.setAm(calcAm(s.getAmm(), s.getKw()));

        // Emulation einer Differentialgleichung durch Iteration
        s.setKm(calcKm(s.getKmm(), s.getKw()));
        s.setAm(calcAm(s.getAmm(), s.getKw()));

        if (s.getKm() > s.getAm()) {
            s.setKw(s.getKw()+1);
        }

        if (s.getAm() > s.getKm()) {
            s.setKw(s.getKw()-1);
        }

        s.setKs(calcKs(s.getKs(), s.isEon(), s.getRpm(), s.getRpmm(), s.getKsv(), t_, s.getT()));
        s.setKv(calcKv(s.getKs(), s.getKv()));
        if (s.getKv() < 0) {s.setRpm(0.0); s.setEon(false);}
        s.setLat(calcLat(lat_, v_, t_, s.getT(), s.getK()));
        s.setLon(calcLon(lon_, v_, t_, s.getT(), s.getK()));

        DecimalFormat df = new DecimalFormat("0.00");
        String log =
                df.format(s.getT())  + " " +
                df.format(s.getWg())  + " " +
                df.format(s.getWr())  + " " +
                df.format(s.getRl())  + " " +
                df.format(s.getBam()) + " " +
                df.format(s.getSfr()) + " " +
                df.format(s.getRpm()) + " " +
                          s.isEon()  + " " +
                          s.isAdn() + " " +
                df.format(s.getVr())  + " " +
                df.format(s.getWew()) + " " +
                df.format(s.getSwg()) + " " +
                df.format(s.getSwr()) + " " +
                df.format(s.getRa())  + " " +
                df.format(s.getBrs()) + " " +
                df.format(s.getBrb()) + " " +
                df.format(s.getBr())  + " " +
                df.format(s.getBw())  + " " +
                          s.isKil()  + " " +
                          s.getBug()  + " " +
                df.format(s.getSf())  + " " +
                df.format(s.getSew()) + " " +
                df.format(s.getWm())  + " " +
                df.format(s.getSm())  + " " +
                df.format(s.getVm())  + " " +
                df.format(s.getBm())  + " " +
                df.format(s.getV())  + " " +
                df.format(s.getK())  + " " +
                          s.getKn()  + " " +
                df.format(s.getKmm()) + " " +
                df.format(s.getKm())  + " " +
                df.format(s.getAm())  + " " +
                df.format(s.getKw())  + " " +
                df.format(s.getKs())  + " " +
                df.format(s.getKv())  + " " +
                df.format(s.getLat()) + " " +
                df.format(s.getLon()) + " " +
                "|";

        System.out.println(log);
        //task.writeLog(log, Logger.SIM);
        //System.out.println("nachmon")
        
        x++;
        
            if(s.isToken()){
            if(x==10){
            } else {
            timer.schedule(new TimerTask(){ public void run(){neuerImpuls();}},500);
            }
           } else {

            }

    }

    private double calcWg(double lat, double lon ){

        double wg = w.getWindForce(lat, lon);//Windgeschwindigkeit wahrer Wind
        return wg;

    }


    private double calcWr(double lat, double lon ){

        double wr = w.getWindDir(lat, lon); //Windrichtung wahrer Wind
        return wr;
    }


    private static double calcVr(double lwl){

        return 1.62*(double)Math.sqrt(lwl);  // Formel Rumpfgeschwindikeit auf Basis m/s

    }

    private static double calcWew(double wr, double k){
        double wr_r = Math.toRadians(wr);
        double k_r = Math.toRadians(k);
        double wew_r = wr_r - k_r + Math.PI*2;

         return Math.toDegrees(wew_r)%360;
    }


    private static double calcSwg(double wg, double v, double wew){
        double wew_r = Math.toRadians(wew);
    // basierend auf Wahren Wind und Fahrtwind wird die Geschwindigkeit des scheinbaren Winds berrechnet
        //return Math.sqrt((wg * wg) + (v * v) + 2*wg*v*Math.cos(wew_r));
     return Math.sqrt(Math.pow(wg+v, 2)-4*wg*v*Math.pow(Math.cos((((Math.toRadians(360-wew))%360)/2)),2));

    }


    // Absolute Richtung des scheinbaren Winds
    // die Himmelsrichtung, in die der Verklicker zeigt
      private static double calcSwr(double wg, double wr, double v, double k, double swg, double wew){
       // swb = arccos*(wg*cos(wr-k)+v)/swg;

         if (swg == 0){ return 0;}
        // double wr_r = Math.toRadians(wr);
        double k_r = Math.toRadians(k);
        double wew_r = Math.toRadians(wew);


        if (0 < wew && wew < 180) {
            // wew_r ok
        }

        if (180 < wew && wew < 360) {
            wew_r = Math.toRadians(360 - wew);
        }

         double swsp_r = Math.acos((wg*Math.cos(wew_r)+v)/swg); // Seitenpeilung des Scheinbaren winds
         double swsp = Math.toDegrees(swsp_r);
         double swr = 0;

         if (0 < wew && wew < 180) {
            swr =  (k + swsp)%360;
        }

        if (180 < wew && wew < 360) {
            swr =  (k - swsp + 360)%360;
        }

         //System.out.println(k  + " " + wew + " " + swsp + " " + swr);
        return swr;

    }


    //    Richtungsänderung
    private static double calcRa(double t_, double t, double v, double rl) {

        return v*(t-t_)*rl;

    }

    //BRS berechnen
    private static double calcBrs(double k, double bam) {
        return subGrad(k,bam);
    }

    //BRB berechnen
    private static double calcBrb(double k, double bam) {
        return addGrad(k,bam);
    }


    //    Baumrichtung
    private static double calcBr(double br_, double swr, double brs, double brb) {

        double brs_ = invGrad(brs); // Gegenwinkel zum Steuerbord maximum
        double brb_ = invGrad(brb);  // Gegenwinkel zum Backbord  maximum

        // --> Br = swr, Segel killt
        if (isInGrad(swr,brs,brb)) {
            return swr;
        }

        // --> Br = brb
        if (isInGrad(swr,brb,brs_)) {
            return brb;
        }

        // --> Br = fällt nach dem kleineren Winkel ins Maximum
        if (isInGrad(swr,brs_,brb_)) {

            if (subGrad(swr,brs_) < subGrad(brb_,swr)) {return brs;}
            if (subGrad(brb_,swr) <= subGrad(swr,brs_)) {return brb;}

            return br_;
        }

        // --> Br = brs
        if (isInGrad(swr,brb_,brs)) {
            return brs;
        }

        return br_;
    }

    private static double calcBw(double k, double br) {

            return Math.abs(subGrad(br,k));

    }

    private static boolean calcKil(double swr, double brs, double brb) {

        if (isInGrad(swr,brs,brb)) {
            return true;
        }

        return false;
    }

    private static String calcBug(double wew) {

        if (0 < wew && wew < 180) {
            return "/";
        }

        if (180 < wew && wew < 360) {
            return "\\";
        }

        return "°";
    }

    private static double calcSf(double sfr, double sfm) {

        return sfr*sfm;

    }

    private static double calcSew(double br, double swr) {

        if (isInGrad(swr,invGrad(br),br)) { //Steuerbord Bug

            return subGrad(br,swr);

        } else  { // Backbord Bug

            return subGrad(swr,br);

        }
    }

    private static double calcWm(double wmp, double swg, double sf) {

        return wmp*swg*sf;

    }


    private static double calcSm(double sew, double wm) {

        return wm * Math.abs(Math.sin((Math.toRadians(sew)/2)));

    }

    private static double calcMm(double rpm, double lm) {

        return rpm*lm/100; //Einfache These

    }

    private static double calcVm(double sm, double sew, double mm) {

        return mm + sm * Math.abs(Math.sin((Math.toRadians(sew))));

    }

    private static double calcBm(double vm, double vr, double v, double m) {

        return (m/10*v/vr)+vm*v/vr;

    }

    private static double calcV(double v, double vm, double bm, double t, double t_, double m, boolean adn) {

        if (adn) { return 0.0; } // Wenn Anker unten
        return v+((vm-bm)*(t-t_)/m);

    }

    private static double calcK(double k, double ra) {

        return addGrad(k,ra);

    }

    private static String calcKn(double k, double swr) {

        double kw = Math.abs(subGrad(k,swr));

        if (kw < 15) return "ImWind";
        if (kw > 15 && kw < 70) return "AmWind";
        if (kw > 70 && kw < 110) return "HalbWind";
        if (kw > 110 && kw < 150) return "RaumWind";
        if (kw > 150 && kw < 180) return "VorWind";
        if (kw > 180 && kw < 220) return "VorWind";
        if (kw > 220 && kw < 280) return "RaumWind";
        if (kw > 280 && kw < 310) return "HalbWind";
        if (kw > 310 && kw < 345) return "AmWind";
        if (kw > 345) return "ImWind";

        return "Kein Wind";

    }

    private static double calcKmm(double sm, double wew) {

        return sm * Math.abs(Math.sin((Math.toRadians(wew)-Math.PI)));

    }

    private static double calcKm(double kmm, double kw) {

        return kmm * Math.abs(Math.sin((Math.toRadians(kw)-Math.PI)));

    }

    private static double calcAm(double amm, double kw) {

        return amm * Math.abs(Math.sin((Math.toRadians(kw)/2)));

    }

    private static double calcKs(double ks, boolean eon, double rpm, double rpmm, double ksv, double t_, double t) {

        if (eon) {
            return rpm/rpmm*ksv*(t-t_)/3600;
        } else {
            return 0;
        }
    }

    private static double calcKv(double ks, double kv) {

        return kv-ks;

    }

    private static double calcLat(double lat, double v, double t_, double t, double k) {

        return lat+v*(t_-t)*Math.sin(Math.toRadians(k))/111111f;

    }

    private static double calcLon(double lon, double v, double t_, double t, double k) {

        return lon+v*(t_-t)*Math.cos(Math.toRadians(k))/111111f;

    }

    // Statische Winkelkalkulation

    public static double addGrad(double a, double b) {

        return (a + b + 360)%360;

    }

    public static double subGrad(double a, double b) {

        return (a - b + 360)%360;

    }

    public static double invGrad(double a) {

        return (a + 180)%360;

    }

     public static boolean isInGrad(double x, double a, double b) {


        if (b < a) { b += 360;}
        if (x < a) { x += 360;}

        if ((a < x) && (x < b)) {
          return true;
        } else {
          return false;
        }
    }

   
     public void digest(Request req){
        s.setRl(req.getRl());
        s.setBam(req.getBam());
        s.setSfr(req.getSfr());
        s.setAdn(req.isAdn());
        s.setEon(req.isEon());
        if (s.isEon()) {
        s.setRpm(req.getRpm());
        } else {
            s.setRpm(0.0);
        }

        // hier fehlen noch die ganzen schalter und listen operationen
        // wpOperation, doLogEntry
/*
        if(req.isDoLogEntry()) {
            doLogEntry();
            req.setDoLogEntry(false); // Schalter zuruecksetzen
        }
/*
        doLogOperation(req.getLgop());
        req.setLgop(""); // Zurücksetzen

        doOperation(req.getWpop(), (List)req.getWegpunkte().getWegpunkt(), (List)s.getWegpunkte().getWegpunkt());
        doOperation(req.getCrop(), (List)req.getCrew().getCrewMember(),    (List)s.getCrew().getCrewMember());
        doOperation(req.getSiop(), (List)req.getStock().getStockItem(),    (List)s.getStock().getStockItem());
        */
    }


    public void neuerImpuls(){
        
        simulation();


    }

    // LIMBO gehoert in die Navigation

    public void WunschZielBerechnung(float new_X, float new_Y, float desired_speed) {


        double entfernung;
        double b1, l1, b2, l2;

        b1 = Math.toRadians(this.s.getLat());
        l1 = Math.toRadians(this.s.getLon());
        b2 = Math.toRadians(new_X);
        l2 = Math.toRadians(new_Y);

        entfernung = (Math.acos(Math.sin(b1)*Math.sin(b2)+Math.cos(b1)*Math.cos(b2)*Math.cos(l1-l2)))*6370;
        //Runden auf 2 Nachkommastellen
        entfernung = Math.round(entfernung*100)/100.0;
        float timeToArrival = (float)(entfernung * 1000)/desired_speed*(1000/3600);


        int stunden = ((int)timeToArrival/3600);        int minuten = ((int)timeToArrival%3600)/60;
        int sekunden = ((int)timeToArrival%(3600)%60);

        System.out.println("TIME TO ARRIVAL =" + stunden + "h/ " + minuten + "m/ " + sekunden + "s" );


    }

      // Verwaltungfunktionen Operationen: i= insert, u=update (immer nur das erste der eingabeliste), d=delete
    // Beispiel "d 3" loescht das dritte objekt

    public void doOperation(String op, List ipl, List obl) {


        if (op.equals("")) { return; }
        String com[] = op.split(" ");
        if (com.length != 2) {return;}
        int lnr = Integer.parseInt(com[1]);
        if (com[0].equals("i")) {
                obl.addAll(lnr,ipl);
        }
        if (com[0].equals("u")) {
            obl.remove(lnr);
            obl.add(lnr,ipl.get(1));
        }
        if (com[0].equals("d")) {
            obl.remove(lnr);
        }

    }
/*
    public void doLogOperation(String logop) {

        if (logop.equals("")) { return; }

        List<LogBookEntry> lbe = (List<LogBookEntry>) s.getLogBookEntries();
        if (logop.equals("dall")) { // Delete all entries
            lbe.clear();
            return;
        }

        String com[] = logop.split(" ");

        if (com.length != 2) {return;}
        if (com[0].equals("d")) {
            ListIterator<LogBookEntry> lei = lbe.listIterator();
            while( lei.hasNext()) {
                LogBookEntry lbet = (LogBookEntry)lei.next();
                if (lbet.getDatum().equals(com[1])) {
                    lbe.remove(lbet);
                }
            }

        } else {
            return;
        }


    }
    
    public void doLogEntry() {

        List<LogBookEntry> lbe = (List<LogBookEntry>) s.getLogBookEntries();

        LogBookEntry nle = new LogBookEntry();

        Calendar syscal = Calendar.getInstance();
        SimpleDateFormat ddf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat tdf = new SimpleDateFormat("HHmm");

        nle.setDatum(ddf.format(syscal.getTime()));
        nle.setUhrzeit(tdf.format(syscal.getTime()));
        nle.setEon(s.isEon());
        nle.setK(s.getK());
        nle.setLog(s.getLog());
        nle.setSfr(s.getSfr());
        nle.setWg(s.getWg());
        nle.setWr(s.getWr());

        lbe.add(nle);
    }







    /*        if(this.s.getNavigation().getZielcoordinate()!=null)
        {
            WunschZielBerechnung((float)this.s.getNavigation().getZielcoordinate().getLat(), (float)this.s.getNavigation().getZielcoordinate().getLon(), v);
        }

     */


    /* SuperLIMBO

        float k = this.s.getNewDraftD(); //aktuelle Kurs des Schiffs
        float v = this.s.getNewDraftV(); //die aktuelle Geschwindigkeit des Schiffs
        float wr = (float)weather.getWindDir(this.s.getPosition().getLat(), this.s.getPosition().getLon()); //Windrichtung wahrer Wind
        float wg = (float)weather.getWindForce(this.s.getPosition().getLat(), this.s.getPosition().getLon());//Windgeschwindigkeit wahrer Wind
        float wew = getwindWinkel();//Windeinfallswinkel
        float assumedWindV = getSWG(wg,wr,v,k); //Die Geschwindigkeit des scheinbaren Winds
        float swb = getSWB(wg,assumedWindV,v,k,wew); // die Richtung des scheinbaren Windes vom Schiff aus gesehen.
        float swr = getSWR(k, swb); //der scheinbare Wind so wie er am Verklicker abzulesen ist. D.h. die Richting von der der scheinbare Wind weht.
        //float swrg= this.s.getscheinWindricht();
        float br;//Baumrichtung
        float sew;//Segelwindeinfallswinkel
        long timediff = task.getScheduleTime() / 1000;


        System.out.println(k + " " + v + " " + wr + " " + wg + " " + wew + " " + assumedWindV + " " + swb + " " + swr);


        // zusaetzlich fuer die Maschine

        int max_rounds=5000; // maximale Anzahl an Motor Umdrehungen pro Minute
        //float rpm; // Motor umdrehungen pro minute
        int timing;
        float benzinVerbrauch;
        float bm;
        boolean rueckwaerts = false;  // falls rueckwaerts fahrend


        //aufruf eines Ziels ueber den Client. Gibt zurueck die berechnung der Zeit bis zur Ankunft des Ziels. Abhaengig von der aktuellen Geschwindigkeit.
        // der bremsmoment. Berechnung bei Machine an und aus. wird benoetigt fuer die Berechnung der aktuellen Geschwindigkeit.

        bm = (float)(0.5 * (v*v) * 0.04 *brake * wasserLinienLaenge*(wasserLinienLaenge*0.2));

        // falls die Geschwindigkeit unter null sinkt, faehrt das Segelschiff rueckwaerts, damit verlagert sich der Bremsmoment auf die andere Seite. Wichtig um die aktuelle Geschwindigkeit zu berechnen, sonst gibt es nur mehr einen Antrieb und keinen Widerstand dagegen. Verhindert das die Maximale Geschwindigkeit beim Rueckwaertsfahren ueberschritten wird.

        if (v < 0) {

            rueckwaerts = true;
            brake=0-bm;

        } else {

            rueckwaerts = false;

        }

        if(!this.s.isEngOnOff())
        {
            /* Motor aus


            //this.s.setScheinWindGeschw((float) Math.sqrt(Math.pow(wg*Math.cos(Math.toRadians(wew))+v,2)+Math.pow(wg*Math.sin(Math.toRadians(wew)),2)));

            if (Math.round(this.getSWG(wg,wr,v,k)*100.0f)/100.0f>0)
            {//wenn scheinbarer wind annaehernd 0 ist.. dann richtung auf 0 setzen (division durch 0 verhindern)
                if (wew<=180) {
                    swr=(float) Math.toDegrees(Math.acos((wg*Math.cos(Math.toRadians(wew))+v)/this.getSWG(wg,wr,v,k)));
                }
                else{
                    swr=-1*(float) Math.toDegrees(Math.acos((wg*Math.cos(Math.toRadians(wew))+v)/this.getSWG(wg,wr,v,k)));
                }
                swr=(360+swr)%360;//auf richtung zwischen 0 und 360
            }
            else{swr=0;}
            this.s.setScheinWindRicht((swr+this.s.getAktKurs())%360); //scheinbarer Wind in globalem Bezugssystem

            */

    //            if ((swr>=315)||swr<=45){
//                br=0; //kommt der wind von 315-45 grad vom boot aus(vorne), ist der baum in der bootsmitte
//            }
//            else {
//                if ((swr<315)&&(swr>180)){
//                    br=-this.s.getBoom(); //kommt der wind zw 180 und 315 grad vom boot aus, ist der baum bb
//                }
//                else{
//                    br=this.s.getBoom();//kommt der wind zw 45 und 180 grad vom boot aus, ist der baum stb
//                }
//            }
//
//
//
//            sew=swr+br;//Segelwindeinfallswinkel
//
//            float x=0;//Berechnungsvariable
//            while ((x<90f)&&(Math.abs((this.getLopSideMoment()*(float)(Math.abs(Math.cos(Math.toRadians(x)))))-(this.s.getSitUpMax()*Math.abs(Math.sin(Math.toRadians(x)))))>10)){ //Kr�ngungsmoment=Aufrichtemoment (toleranz 10N)
//                x=x+0.001f;
//            }
//
//            if (br>0) x=-x; //Wenn baum auf steuerboard dann kraengung in andere Richtung
//            this.s.setAktKraengung(x);
//
//            System.out.println("x: "+x);
//            System.out.println("km: "+(this.getLopSideMoment()*(float)(Math.abs(Math.cos(Math.toRadians(x))))));
//            System.out.println("am: "+(this.s.getSitUpMax()*Math.abs(Math.sin(Math.toRadians(x)))));
//            System.out.println("wew: "+getwindWinkel());
//            System.out.println("Scheinbare Windgeschwindigkeit: "+ assumedWindV);
//            System.out.println("swr: "+ this.getSWR(k, swb));
//            System.out.println("sm: "+this.getsailMoment());
//            System.out.println("sew: "+sew);
//            System.out.println("swrg: "+this.s.getWindparameter().getScheinbareWindrichtungSchiff()); //global
//            System.out.println("br: "+br);
//            System.out.println("wm: "+this.getWindmoment());
//            System.out.println("kmm: "+this.getLopSideMoment());
//
//            this.s.getPosition().setLat(this.s.getPosition().getLat()+v*timediff* (float) Math.sin(Math.toRadians(this.s.getNewDraftD()))/111111f);
//            this.s.getPosition().setLon(this.s.getPosition().getLon()+v*timediff* (float) Math.cos(Math.toRadians(this.s.getNewDraftD()))/111111f);
//            this.s.setNewDraftD((360+(k+v*timediff*this.s.getTiller()))%360);
//            this.s.setNewDraftV(v+(((float)this.getSpeed()-brake)*timediff/this.s.getDraftWeight()));

            /* clear the log window !! only temporarily possible */
            //task.os_copy.server.log.clearLog();

//            task.writeLog(this.s.getSchiffsname());
//            task.writeLog("Motor aus Kurs:"+k);
//            task.writeLog("Geschwindigkeit:"+v);
//            task.writeLog("Kraengung:"+this.s.getAktKraengung());
//            task.writeLog("Lat:"+this.s.getPosition().getLat());
//            task.writeLog("Lon:"+this.s.getPosition().getLon());
//            task.writeLog("Windrichtung: " + weather.getWindDir(this.s.getPosition().getLat(), this.s.getPosition().getLon()));
//            task.writeLog("Windgeschwindigkeit: " + weather.getWindForce(this.s.getPosition().getLat(), this.s.getPosition().getLon()));
//            task.writeLog("Bremsmoment: " + brake);
//            task.writeLog("Vortriebsmoment: " + this.getSpeed());
//            task.writeLog("scheinbare Windrichtung: " + this.getSWR(k, swb));
//            task.writeLog("scheinbare Windrichtung vom boot aus: " +swb);
//            task.writeLog("scheinbare Windgeschwindigkeit: " + assumedWindV);
//            task.writeLog("---------------------------\n");
//
//            }
//        else  { // Motor ist an
//
//
//
//            /* MOTOR IST AN!
//
//            // Drehmoment in Nm. Um den Antrieb oder Vortrieb zu berechnen, brauchen wir zuerst die Kraft eines Drehmomentes.
//
//            double Drehmoment = (0.5 *(this.s.getMaxRumpfSpeed()*this.s.getMaxRumpfSpeed())*0.04 * wasserLinienLaenge*(wasserLinienLaenge*0.2))/(2 * Math.PI * max_rounds/60);
//            System.out.println("maxRumpfSpeed=" + this.s.getMaxRumpfSpeed());
//
//            // Wir rechnen die uebergegebenen Umdrehungen oder Rounds Per Minute in Umdrehungen pro Sekunde um.
//
//            rpm = this.s.getRpmActual()/60;
//            this.s.setRpmActual(this.s.getRpmActual());
//
//            float PKraft = 2 * (float)Math.PI * (float)Drehmoment  * rpm;    // PKraft rechnet den aktuellen Vortriebsmoment aus. in nm/s.
//              System.out.println("Vor/Antrieb" + PKraft);
//
//              vm = PKraft;     //Antriebs- oder Vortriebsmoment
//              System.out.println("vm:"+vm);
//
//            // zeit seit beginn der fahrt
//
//            timing = (int)this.s.getTimer() + 1;
//            this.s.setTimer(timing);
//            this.s.setAktKraengung(0);
//            //Kraengung auf 0 setzen, Kein Segeldruck
//            //this.s.setAktGeschwindigkeit(rpm * 0.01f);
//
//            this.s.getPosition().setLat(this.s.getPosition().getLat()+v*timediff* (float) Math.sin(Math.toRadians(this.s.getNewDraftD()))/111111f);
//            this.s.getPosition().setLon(this.s.getPosition().getLon()+v*timediff* (float) Math.cos(Math.toRadians(this.s.getNewDraftD()))/111111f);
//             */
//            // Benzinverbrauch bei 0.5L/KM -> 0.0005l/m.
//
//            if (! rueckwaerts)
//
//             { // normale fahrt
//
//            benzinVerbrauch = (float)(this.s.getFuel() -(v) * 0.0005);
//
//            }
//
//                else
//                { // falls wir rueckwaerts fahren haetten wir eine negative Fahrtgeschwindigkeit, damit wuerde sich der Benzinstand wieder nach oben bewegen statt weniger zu werden.
//
//            benzinVerbrauch = (float)(this.s.getFuel() +
//            (v) * 0.0005);
//
//                }
//
//            this.s.setFuel(benzinVerbrauch);
//
//
//            this.s.setNewDraftD((360+(k+v*timediff*this.s.getTiller()))%360);
//            this.s.setNewDraftV(v+((vm-brake)*timediff/this.s.getDraftWeight()));
//
//
//            /* clear the log window !! only temporarily possible */
//            //task.os_copy.server.log.clearLog();
//            //System.out.println("Motor an Kurs:"+this.s.getNewDraftD());
//            task.writeLog("Motor an Kurs:"+this.s.getNewDraftD());
//            //System.out.println("Geschwindigkeit:"+v);
//            task.writeLog("Geschwindigkeit:"+v);
//            //System.out.println("Kraengung:"+this.s.getAktKraengung());
//            task.writeLog("Kraengung:"+this.s.getAktKraengung());
//            //System.out.println("X:"+this.s.getPosition().getLat());
//            task.writeLog("Lat:"+this.s.getPosition().getLat());
//            //System.out.println("Y:"+this.s.getPosition().getLon());
//            task.writeLog("Lon:"+this.s.getPosition().getLon());
//            task.writeLog("Windrichtung: " + weather.getWindDir(this.s.getPosition().getLat(), this.s.getPosition().getLon()));
//            task.writeLog("Windgeschwindigkeit: " + weather.getWindForce(this.s.getPosition().getLat(), this.s.getPosition().getLon()));
//            task.writeLog("Bremsmoment: " + brake);
//            task.writeLog("Vortriebsmoment: " + this.getSpeed());
//            //System.out.println("---------------------------\n");
//            task.writeLog("---------------------------\n");

////    nächster Ticker (neuer Zeitpunkt)
//    public long getnewTime(long time) {
//        long newTime = time+2;
//     return newTime;
//    }






    public void initialisiere(){
        count++;
        
        s.setSchiffsname("s"+ count);
        s.setLon(0);
        s.setLat(0);
        
        s.setToken(false);
        s.setT(0);
        s.setWg(10);
        s.setWr(270);
        s.setRl(0);
        s.setBam(0);
        s.setSfr(0);
        s.setEon(false);
        s.setAdn(false);
        s.setRpm(0);
        s.setSfm(300);
        s.setM(12000);
        s.setLp(50);
        s.setLwl(15);
        s.setAmm(20000);
        s.setLbm(9000);
        s.setKsm(300);
        s.setKsv(7);
        s.setRpmm(4000);
        s.setDdp(7);
        s.setDds(2);
        s.setLm(81);
        s.setWmp(10);
        s.setVr(6.27);
        s.setWew(150);
        s.setSwg(12);
        s.setSwr(280);
        s.setRa(0);
        s.setBrs(120);
        s.setBrb(120);
        s.setBr(120);
        s.setKil(false);
        s.setSf(0);
        s.setSew(150);
        s.setWm(0);
        s.setSm(0);
        s.setVm(0);
        s.setBm(0);
        s.setV(4.683);
        s.setK(120);
        s.setKn("Init");
        s.setKmm(8875.29);
        s.setKm(8107.98);
        s.setAm(8134.73);
        s.setKw(10);
        s.setAb(0);
        s.setStm(124.7);
        s.setKs(0.0);
        s.setKv(1);
        //Coordinate po = new Coordinate();
        //po.setLat(43.84523);
        //po.setLon(15.58575);
        //s.setPosition(po);
        //s.setWegpunkte(new Ship.Wegpunkte());
        //Wegpunkt wp1 = new Wegpunkt();
        //wp1.setTag("MU123");
        //Coordinate wpco1 = new Coordinate();
        //wpco1.setLat(43.835991);
        //wpco1.setLon(15.593524);
        //wp1.setPosition(wpco1);
       // s.getWegpunkte().getWegpunkt().add(wp1);
        //Wegpunkt zl = new Wegpunkt();
        //zl.setTag("Murter Hramina");
        //Coordinate zlco = new Coordinate();
        //zlco.setLat(43.827271);
        //zlco.setLon(15.590145);
        //zl.setPosition(zlco);
        //s.getWegpunkte().getWegpunkt().add(zl);
        //s.setSurroundingShips(new Ship.SurroundingShips());
        //s.setLogBookEntries(new Ship.LogBookEntries());
        //s.setCrew(new Ship.Crew());
        //CrewMember cm1 = new CrewMember();
        //cm1.setVorname("Anton");
        //cm1.setNachname("Kuh");
        //cm1.setSkipper(true);
        //cm1.setGeschlecht("m");
        //cm1.setGewicht(85);
        //s.getCrew().getCrewMember().add(cm1);
        //CrewMember cm2 = new CrewMember();
        //cm2.setVorname("Victor");
        //cm2.setNachname("Hugo");
        //cm2.setSkipper(false);
        //cm2.setGeschlecht("m");
        //cm2.setGewicht(85);
        //s.getCrew().getCrewMember().add(cm2);
        //s.setStock(new Ship.Stock());
        //StockItem si = new StockItem();
        //si.setGut("Wasser");
        //si.setMenge(200.0);
        //si.setMaxmenge(300.0);
        //s.getStock().getStockItem().add(si);



        simulation();
    }

    public static void main(String[] args){
        SchiffSimulation sim = new SchiffSimulation();
       System.out.println(LOGTITLE);
        sim.initialisiere();

    } 
}
