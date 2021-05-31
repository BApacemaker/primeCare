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
@Table(name = "receipt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receipt.nextId", query = "SELECT MAX(r.idreceipt) FROM Receipt r"),
    @NamedQuery(name = "Receipt.findAll", query = "SELECT r FROM Receipt r"),
    @NamedQuery(name = "Receipt.findByIdreceipt", query = "SELECT r FROM Receipt r WHERE r.idreceipt = :idreceipt"),
    @NamedQuery(name = "Receipt.findByClinicname", query = "SELECT r FROM Receipt r WHERE r.clinicname = :clinicname"),
    @NamedQuery(name = "Receipt.findByBranchname", query = "SELECT r FROM Receipt r WHERE r.branchname = :branchname"),
    @NamedQuery(name = "Receipt.findByDate", query = "SELECT r FROM Receipt r WHERE r.date = :date")})
public class Receipt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idreceipt")
    private Integer idreceipt;
    @Size(max = 254)
    @Column(name = "clinicname")
    private String clinicname;
    @Size(max = 254)
    @Column(name = "branchname")
    private String branchname;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "idmedicalservice", referencedColumnName = "idmedicalservice")
    @ManyToOne(optional = false)
    private Medicalservice idmedicalservice;
    @JoinColumn(name = "idpatient", referencedColumnName = "idpatient")
    @ManyToOne
    private Patient idpatient;

    public Receipt() {
    }

    public Receipt(Integer idreceipt) {
        this.idreceipt = idreceipt;
    }

    public Integer getIdreceipt() {
        return idreceipt;
    }

    public void setIdreceipt(Integer idreceipt) {
        this.idreceipt = idreceipt;
    }

    public String getClinicname() {
        return clinicname;
    }

    public void setClinicname(String clinicname) {
        this.clinicname = clinicname;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Medicalservice getIdmedicalservice() {
        return idmedicalservice;
    }

    public void setIdmedicalservice(Medicalservice idmedicalservice) {
        this.idmedicalservice = idmedicalservice;
    }

    public Patient getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(Patient idpatient) {
        this.idpatient = idpatient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreceipt != null ? idreceipt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receipt)) {
            return false;
        }
        Receipt other = (Receipt) object;
        if ((this.idreceipt == null && other.idreceipt != null) || (this.idreceipt != null && !this.idreceipt.equals(other.idreceipt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Receipt[ idreceipt=" + idreceipt + " ]";
    }
    
}
