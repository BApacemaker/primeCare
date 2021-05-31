
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pas
 */
@Entity
@Table(name = "discharge")
@XmlRootElement
@NamedQueries({
    
    @NamedQuery(name = "Discharge.findbydisch", query = "SELECT d FROM Discharge d WHERE d.reason = :reason AND d.date = :date AND d.time = :time"),
    @NamedQuery(name = "Discharge.findbydischargeDate", query = "SELECT d.date FROM Discharge d"),
    @NamedQuery(name = "Discharge.nextId", query = "SELECT MAX(d.iddischarge) FROM Discharge d"),
    @NamedQuery(name = "Discharge.findAll", query = "SELECT d FROM Discharge d"),
    @NamedQuery(name = "Discharge.findByIddischarge", query = "SELECT d FROM Discharge d WHERE d.iddischarge = :iddischarge"),
    @NamedQuery(name = "Discharge.findByDate", query = "SELECT d FROM Discharge d WHERE d.date = :date"),
    @NamedQuery(name = "Discharge.findByTime", query = "SELECT d FROM Discharge d WHERE d.time = :time"),
    @NamedQuery(name = "Discharge.findByPatcondition", query = "SELECT d FROM Discharge d WHERE d.patcondition = :patcondition"),
    @NamedQuery(name = "Discharge.findByReason", query = "SELECT d FROM Discharge d WHERE d.reason = :reason")})
public class Discharge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddischarge")
    private Integer iddischarge;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Size(max = 254)
    @Column(name = "patcondition")
    private String patcondition;
    @Size(max = 254)
    @Column(name = "reason")
    private String reason;
    @JoinColumn(name = "idadmission", referencedColumnName = "idadmission")
    @ManyToOne
    private Admission idadmission;

    public Discharge() {
    }

    public Discharge(Integer iddischarge) {
        this.iddischarge = iddischarge;
    }

    public Integer getIddischarge() {
        return iddischarge;
    }

    public void setIddischarge(Integer iddischarge) {
        this.iddischarge = iddischarge;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPatcondition() {
        return patcondition;
    }

    public void setPatcondition(String patcondition) {
        this.patcondition = patcondition;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Admission getIdadmission() {
        return idadmission;
    }

    public void setIdadmission(Admission idadmission) {
        this.idadmission = idadmission;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddischarge != null ? iddischarge.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discharge)) {
            return false;
        }
        Discharge other = (Discharge) object;
        if ((this.iddischarge == null && other.iddischarge != null) || (this.iddischarge != null && !this.iddischarge.equals(other.iddischarge))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Discharge[ iddischarge=" + iddischarge + " ]";
    }
    
}
