/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pas
 */
@Entity
@Table(name = "admission")
@XmlRootElement   
@NamedQueries({
 @NamedQuery(name = "Admission.findbyadm", query = "SELECT a FROM Admission a WHERE a.purpose = :purpose AND a.date = :date AND a.time = :time"),
    @NamedQuery(name = "Admission.discharge", query = "SELECT a.idward FROM Admission a"),
    @NamedQuery(name = "Admission.duration", query = "SELECT a.dateline FROM Admission a"),
    @NamedQuery(name = "Admission.nextId", query = "SELECT MAX(a.idadmission) FROM Admission a"),
    @NamedQuery(name = "Admission.findAll", query = "SELECT a FROM Admission a"),
    @NamedQuery(name = "Admission.findByIdadmission", query = "SELECT a FROM Admission a WHERE a.idadmission = :idadmission"),
    @NamedQuery(name = "Admission.findByTime", query = "SELECT a FROM Admission a WHERE a.time = :time"),
    @NamedQuery(name = "Admission.findByDate", query = "SELECT a FROM Admission a WHERE a.date = :date"),
    @NamedQuery(name = "Admission.findByPurpose", query = "SELECT a FROM Admission a WHERE a.purpose = :purpose"),
    @NamedQuery(name = "Admission.findByDuration", query = "SELECT a FROM Admission a WHERE a.dateline = :dateline")})
public class Admission implements Serializable {

    @Column(name = "dateline")
    @Temporal(TemporalType.DATE)
    private Date dateline;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idadmission")
    private Integer idadmission;
    
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 254)
    
    @Column(name = "purpose")
    private String purpose;
    @Size(max = 254)
    
    @OneToMany(mappedBy = "idadmission")
    private List<Treatment> treatmentList;
    @JoinColumn(name = "idpatient", referencedColumnName = "idpatient")
    @ManyToOne
    private Patient idpatient;
    @JoinColumn(name = "idward", referencedColumnName = "idward")
    @ManyToOne(optional = false)
    private Ward idward;
    @OneToMany(mappedBy = "idadmission")
    private List<Discharge> dischargeList;

    public Admission() {
    }

    public Admission(Integer idadmission) {
        this.idadmission = idadmission;
    }

    public Integer getIdadmission() {
        return idadmission;
    }

    public void setIdadmission(Integer idadmission) {
        this.idadmission = idadmission;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    
 
    @XmlTransient
    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(List<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }

    public Patient getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(Patient idpatient) {
        this.idpatient = idpatient;
    }

    public Ward getIdward() {
        return idward;
    }

    public void setIdward(Ward idward) {
        this.idward = idward;
    }

    @XmlTransient
    public List<Discharge> getDischargeList() {
        return dischargeList;
    }

    public void setDischargeList(List<Discharge> dischargeList) {
        this.dischargeList = dischargeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadmission != null ? idadmission.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admission)) {
            return false;
        }
        Admission other = (Admission) object;
        if ((this.idadmission == null && other.idadmission != null) || (this.idadmission != null && !this.idadmission.equals(other.idadmission))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Admission[ idadmission=" + idadmission + " ]";
    }

    public Date getDateLine() {
        return dateline;
    }

    public void setDateLine(Date dateLine) {
        this.dateline = dateLine;
    }  
    
}
