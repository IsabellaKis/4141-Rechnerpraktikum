/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author h1451938
 */
@Entity
@Table(name = "schiffstyp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schiffstyp.findAll", query = "SELECT s FROM Schiffstyp s")
    , @NamedQuery(name = "Schiffstyp.findBySegelflaecheMax", query = "SELECT s FROM Schiffstyp s WHERE s.segelflaecheMax = :segelflaecheMax")
    , @NamedQuery(name = "Schiffstyp.findByGewicht", query = "SELECT s FROM Schiffstyp s WHERE s.gewicht = :gewicht")
    , @NamedQuery(name = "Schiffstyp.findByLateralplan", query = "SELECT s FROM Schiffstyp s WHERE s.lateralplan = :lateralplan")
    , @NamedQuery(name = "Schiffstyp.findByLeistungMotor", query = "SELECT s FROM Schiffstyp s WHERE s.leistungMotor = :leistungMotor")
    , @NamedQuery(name = "Schiffstyp.findByAbstandHeckSchraube", query = "SELECT s FROM Schiffstyp s WHERE s.abstandHeckSchraube = :abstandHeckSchraube")
    , @NamedQuery(name = "Schiffstyp.findByAbstandHeckDrehpunkt", query = "SELECT s FROM Schiffstyp s WHERE s.abstandHeckDrehpunkt = :abstandHeckDrehpunkt")
    , @NamedQuery(name = "Schiffstyp.findBySchifflaengeWasserlinie", query = "SELECT s FROM Schiffstyp s WHERE s.schifflaengeWasserlinie = :schifflaengeWasserlinie")
    , @NamedQuery(name = "Schiffstyp.findByMaschinenumdrehungMax", query = "SELECT s FROM Schiffstyp s WHERE s.maschinenumdrehungMax = :maschinenumdrehungMax")
    , @NamedQuery(name = "Schiffstyp.findByAufrichtemomentMax", query = "SELECT s FROM Schiffstyp s WHERE s.aufrichtemomentMax = :aufrichtemomentMax")
    , @NamedQuery(name = "Schiffstyp.findByKraftstoffverbrauch", query = "SELECT s FROM Schiffstyp s WHERE s.kraftstoffverbrauch = :kraftstoffverbrauch")
    , @NamedQuery(name = "Schiffstyp.findByLateralbremsmoment", query = "SELECT s FROM Schiffstyp s WHERE s.lateralbremsmoment = :lateralbremsmoment")
    , @NamedQuery(name = "Schiffstyp.findByKraftstoffMax", query = "SELECT s FROM Schiffstyp s WHERE s.kraftstoffMax = :kraftstoffMax")
    , @NamedQuery(name = "Schiffstyp.findBySchiffstypId", query = "SELECT s FROM Schiffstyp s WHERE s.schiffstypId = :schiffstypId")})
public class Schiffstyp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "segelflaeche_max")
    private Integer segelflaecheMax;
    @Column(name = "gewicht")
    private Integer gewicht;
    @Column(name = "lateralplan")
    private Integer lateralplan;
    @Column(name = "leistung_motor")
    private Integer leistungMotor;
    @Column(name = "abstand_heck_schraube")
    private Integer abstandHeckSchraube;
    @Column(name = "abstand_heck_drehpunkt")
    private Integer abstandHeckDrehpunkt;
    @Column(name = "schifflaenge_wasserlinie")
    private Integer schifflaengeWasserlinie;
    @Column(name = "maschinenumdrehung_max")
    private Integer maschinenumdrehungMax;
    @Column(name = "aufrichtemoment_max")
    private Integer aufrichtemomentMax;
    @Column(name = "kraftstoffverbrauch")
    private Integer kraftstoffverbrauch;
    @Column(name = "lateralbremsmoment")
    private Integer lateralbremsmoment;
    @Column(name = "kraftstoff_max")
    private Integer kraftstoffMax;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "schiffstyp_id")
    private Integer schiffstypId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "schiffstyp")
    private Schiff schiff;

    public Schiffstyp() {
    }

    public Schiffstyp(Integer schiffstypId) {
        this.schiffstypId = schiffstypId;
    }

    public Integer getSegelflaecheMax() {
        return segelflaecheMax;
    }

    public void setSegelflaecheMax(Integer segelflaecheMax) {
        this.segelflaecheMax = segelflaecheMax;
    }

    public Integer getGewicht() {
        return gewicht;
    }

    public void setGewicht(Integer gewicht) {
        this.gewicht = gewicht;
    }

    public Integer getLateralplan() {
        return lateralplan;
    }

    public void setLateralplan(Integer lateralplan) {
        this.lateralplan = lateralplan;
    }

    public Integer getLeistungMotor() {
        return leistungMotor;
    }

    public void setLeistungMotor(Integer leistungMotor) {
        this.leistungMotor = leistungMotor;
    }

    public Integer getAbstandHeckSchraube() {
        return abstandHeckSchraube;
    }

    public void setAbstandHeckSchraube(Integer abstandHeckSchraube) {
        this.abstandHeckSchraube = abstandHeckSchraube;
    }

    public Integer getAbstandHeckDrehpunkt() {
        return abstandHeckDrehpunkt;
    }

    public void setAbstandHeckDrehpunkt(Integer abstandHeckDrehpunkt) {
        this.abstandHeckDrehpunkt = abstandHeckDrehpunkt;
    }

    public Integer getSchifflaengeWasserlinie() {
        return schifflaengeWasserlinie;
    }

    public void setSchifflaengeWasserlinie(Integer schifflaengeWasserlinie) {
        this.schifflaengeWasserlinie = schifflaengeWasserlinie;
    }

    public Integer getMaschinenumdrehungMax() {
        return maschinenumdrehungMax;
    }

    public void setMaschinenumdrehungMax(Integer maschinenumdrehungMax) {
        this.maschinenumdrehungMax = maschinenumdrehungMax;
    }

    public Integer getAufrichtemomentMax() {
        return aufrichtemomentMax;
    }

    public void setAufrichtemomentMax(Integer aufrichtemomentMax) {
        this.aufrichtemomentMax = aufrichtemomentMax;
    }

    public Integer getKraftstoffverbrauch() {
        return kraftstoffverbrauch;
    }

    public void setKraftstoffverbrauch(Integer kraftstoffverbrauch) {
        this.kraftstoffverbrauch = kraftstoffverbrauch;
    }

    public Integer getLateralbremsmoment() {
        return lateralbremsmoment;
    }

    public void setLateralbremsmoment(Integer lateralbremsmoment) {
        this.lateralbremsmoment = lateralbremsmoment;
    }

    public Integer getKraftstoffMax() {
        return kraftstoffMax;
    }

    public void setKraftstoffMax(Integer kraftstoffMax) {
        this.kraftstoffMax = kraftstoffMax;
    }

    public Integer getSchiffstypId() {
        return schiffstypId;
    }

    public void setSchiffstypId(Integer schiffstypId) {
        this.schiffstypId = schiffstypId;
    }

    public Schiff getSchiff() {
        return schiff;
    }

    public void setSchiff(Schiff schiff) {
        this.schiff = schiff;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schiffstypId != null ? schiffstypId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schiffstyp)) {
            return false;
        }
        Schiffstyp other = (Schiffstyp) object;
        if ((this.schiffstypId == null && other.schiffstypId != null) || (this.schiffstypId != null && !this.schiffstypId.equals(other.schiffstypId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Schiffstyp[ schiffstypId=" + schiffstypId + " ]";
    }
    
}
