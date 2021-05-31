/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pas
 */
@Entity
@Table(name = "medicalservice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicalservice.nextId", query = "SELECT MAX(m.idmedicalservice) FROM Medicalservice m"),
    @NamedQuery(name = "Medicalservice.findAll", query = "SELECT m FROM Medicalservice m"),
    @NamedQuery(name = "Medicalservice.findByIdmedicalservice", query = "SELECT m FROM Medicalservice m WHERE m.idmedicalservice = :idmedicalservice"),
    @NamedQuery(name = "Medicalservice.findByName", query = "SELECT m FROM Medicalservice m WHERE m.name = :name"),
    @NamedQuery(name = "Medicalservice.findByCost", query = "SELECT m FROM Medicalservice m WHERE m.cost = :cost")})
public class Medicalservice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmedicalservice")
    private Integer idmedicalservice;
    @Size(max = 254)
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private Integer cost;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmedicalservice")
    private List<Treatment> treatmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmedicalservice")
    private List<Receipt> receiptList;

    public Medicalservice() {
    }

    public Medicalservice(Integer idmedicalservice) {
        this.idmedicalservice = idmedicalservice;
    }

    public Integer getIdmedicalservice() {
        return idmedicalservice;
    }

    public void setIdmedicalservice(Integer idmedicalservice) {
        this.idmedicalservice = idmedicalservice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @XmlTransient
    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(List<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }

    @XmlTransient
    public List<Receipt> getReceiptList() {
        return receiptList;
    }

    public void setReceiptList(List<Receipt> receiptList) {
        this.receiptList = receiptList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedicalservice != null ? idmedicalservice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicalservice)) {
            return false;
        }
        Medicalservice other = (Medicalservice) object;
        if ((this.idmedicalservice == null && other.idmedicalservice != null) || (this.idmedicalservice != null && !this.idmedicalservice.equals(other.idmedicalservice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Medicalservice[ idmedicalservice=" + idmedicalservice + " ]";
    }
    
}
