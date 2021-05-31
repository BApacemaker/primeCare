/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "treatment")
@XmlRootElement   
@NamedQueries({
    @NamedQuery(name = "Treatment.findbytreate", query = "SELECT t FROM Treatment t WHERE t.detail = :detail AND t.date = :date AND t.time = :time"),
    @NamedQuery(name = "Treatment.nextId", query = "SELECT MAX(t.idtreatment) FROM Treatment t"),
    @NamedQuery(name = "Treatment.findAll", query = "SELECT t FROM Treatment t"),
    @NamedQuery(name = "Treatment.findByIdtreatment", query = "SELECT t FROM Treatment t WHERE t.idtreatment = :idtreatment"),
    @NamedQuery(name = "Treatment.findByDetail", query = "SELECT t FROM Treatment t WHERE t.detail = :detail"),
    @NamedQuery(name = "Treatment.findByDate", query = "SELECT t FROM Treatment t WHERE t.date = :date"),
    @NamedQuery(name = "Treatment.findByTime", query = "SELECT t FROM Treatment t WHERE t.time = :time")})
public class Treatment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtreatment")
    private Integer idtreatment;
    @Size(max = 254)
    @Column(name = "detail")
    private String detail;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @JoinColumn(name = "idadmission", referencedColumnName = "idadmission")
    @ManyToOne
    private Admission idadmission;
    @JoinColumn(name = "idmedicalservice", referencedColumnName = "idmedicalservice")
    @ManyToOne(optional = false)
    private Medicalservice idmedicalservice;

    public Treatment() {
    }

    public Treatment(Integer idtreatment) {
        this.idtreatment = idtreatment;
    }

    public Integer getIdtreatment() {
        return idtreatment;
    }

    public void setIdtreatment(Integer idtreatment) {
        this.idtreatment = idtreatment;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public Admission getIdadmission() {
        return idadmission;
    }

    public void setIdadmission(Admission idadmission) {
        this.idadmission = idadmission;
    }

    public Medicalservice getIdmedicalservice() {
        return idmedicalservice;
    }

    public void setIdmedicalservice(Medicalservice idmedicalservice) {
        this.idmedicalservice = idmedicalservice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtreatment != null ? idtreatment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Treatment)) {
            return false;
        }
        Treatment other = (Treatment) object;
        if ((this.idtreatment == null && other.idtreatment != null) || (this.idtreatment != null && !this.idtreatment.equals(other.idtreatment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Treatment[ idtreatment=" + idtreatment + " ]";
    }
    
}
