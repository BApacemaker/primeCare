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
@Table(name = "transfer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transfer.nextId", query = "SELECT MAX(t.idtransfer) FROM Transfer t"),
    @NamedQuery(name = "Transfer.findAll", query = "SELECT t FROM Transfer t"),
    @NamedQuery(name = "Transfer.findByIdtransfer", query = "SELECT t FROM Transfer t WHERE t.idtransfer = :idtransfer"),
    @NamedQuery(name = "Transfer.findByDate", query = "SELECT t FROM Transfer t WHERE t.date = :date"),
    @NamedQuery(name = "Transfer.findByTime", query = "SELECT t FROM Transfer t WHERE t.time = :time"),
    @NamedQuery(name = "Transfer.findByPurpose", query = "SELECT t FROM Transfer t WHERE t.purpose = :purpose"),
    @NamedQuery(name = "Transfer.findByPatcondition", query = "SELECT t FROM Transfer t WHERE t.patcondition = :patcondition")})
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtransfer")
    private Integer idtransfer;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Size(max = 254)
    @Column(name = "purpose")
    private String purpose;
    @Size(max = 254)
    @Column(name = "patcondition")
    private String patcondition;
    @JoinColumn(name = "idbranch", referencedColumnName = "idbranch")
    @ManyToOne
    private Branch idbranch;
    @JoinColumn(name = "idpatient", referencedColumnName = "idpatient")
    @ManyToOne
    private Patient idpatient;

    public Transfer() {
    }

    public Transfer(Integer idtransfer) {
        this.idtransfer = idtransfer;
    }

    public Integer getIdtransfer() {
        return idtransfer;
    }

    public void setIdtransfer(Integer idtransfer) {
        this.idtransfer = idtransfer;
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPatcondition() {
        return patcondition;
    }

    public void setPatcondition(String patcondition) {
        this.patcondition = patcondition;
    }

    public Branch getIdbranch() {
        return idbranch;
    }

    public void setIdbranch(Branch idbranch) {
        this.idbranch = idbranch;
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
        hash += (idtransfer != null ? idtransfer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transfer)) {
            return false;
        }
        Transfer other = (Transfer) object;
        if ((this.idtransfer == null && other.idtransfer != null) || (this.idtransfer != null && !this.idtransfer.equals(other.idtransfer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Transfer[ idtransfer=" + idtransfer + " ]";
    }
    
}
