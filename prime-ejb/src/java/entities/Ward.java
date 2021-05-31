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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ward")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ward.nextId", query = "SELECT MAX(w.idward) FROM Ward w"),
    @NamedQuery(name = "Ward.findAll", query = "SELECT w FROM Ward w"),
    @NamedQuery(name = "Ward.findByIdward", query = "SELECT w FROM Ward w WHERE w.idward = :idward"),
    @NamedQuery(name = "Ward.findByName", query = "SELECT w FROM Ward w WHERE w.name = :name"),
    @NamedQuery(name = "Ward.findByState", query = "SELECT w FROM Ward w WHERE w.state = :state"),
    @NamedQuery(name = "Ward.findByCode", query = "SELECT w FROM Ward w WHERE w.code = :code")})
public class Ward implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idward")
    private Integer idward;
    @Size(max = 254)
    @Column(name = "name")
    private String name;
    @Size(max = 254)
    @Column(name = "state")
    private String state;
    @Size(max = 254)
    @Column(name = "code")
    private String code;
    @OneToMany(mappedBy = "idward")
    private List<Bed> bedList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idward")
    private List<Admission> admissionList;
    @JoinColumn(name = "idbranch", referencedColumnName = "idbranch")
    @ManyToOne(optional = false)
    private Branch idbranch;
    @JoinColumn(name = "idwardcategory", referencedColumnName = "idwardcategory")
    @ManyToOne(optional = false)
    private Wardcategory idwardcategory;

    public Ward() {
    }

    public Ward(Integer idward) {
        this.idward = idward;
    }

    public Integer getIdward() {
        return idward;
    }

    public void setIdward(Integer idward) {
        this.idward = idward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public List<Bed> getBedList() {
        return bedList;
    }

    public void setBedList(List<Bed> bedList) {
        this.bedList = bedList;
    }

    @XmlTransient
    public List<Admission> getAdmissionList() {
        return admissionList;
    }

    public void setAdmissionList(List<Admission> admissionList) {
        this.admissionList = admissionList;
    }

    public Branch getIdbranch() {
        return idbranch;
    }

    public void setIdbranch(Branch idbranch) {
        this.idbranch = idbranch;
    }

    public Wardcategory getIdwardcategory() {
        return idwardcategory;
    }

    public void setIdwardcategory(Wardcategory idwardcategory) {
        this.idwardcategory = idwardcategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idward != null ? idward.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ward)) {
            return false;
        }
        Ward other = (Ward) object;
        if ((this.idward == null && other.idward != null) || (this.idward != null && !this.idward.equals(other.idward))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ward[ idward=" + idward + " ]";
    }
    
}
