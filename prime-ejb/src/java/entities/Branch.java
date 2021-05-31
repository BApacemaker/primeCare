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
@Table(name = "branch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
    @NamedQuery(name = "Branch.findByIdbranch", query = "SELECT b FROM Branch b WHERE b.idbranch = :idbranch"),
    @NamedQuery(name = "Branch.findByName", query = "SELECT b FROM Branch b WHERE b.name = :name"),
    @NamedQuery(name = "Branch.findByLocation", query = "SELECT b FROM Branch b WHERE b.location = :location")})
public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbranch")
    private Integer idbranch;
    @Size(max = 254)
    @Column(name = "name")
    private String name;
    @Size(max = 254)
    @Column(name = "location")
    private String location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbranch")
    private List<Ward> wardList;
    @OneToMany(mappedBy = "idbranch")
    private List<Transfer> transferList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbranch")
    private List<Department> departmentList;

    public Branch() {
    }

    public Branch(Integer idbranch) {
        this.idbranch = idbranch;
    }

    public Integer getIdbranch() {
        return idbranch;
    }

    public void setIdbranch(Integer idbranch) {
        this.idbranch = idbranch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public List<Ward> getWardList() {
        return wardList;
    }

    public void setWardList(List<Ward> wardList) {
        this.wardList = wardList;
    }

    @XmlTransient
    public List<Transfer> getTransferList() {
        return transferList;
    }

    public void setTransferList(List<Transfer> transferList) {
        this.transferList = transferList;
    }

    @XmlTransient
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbranch != null ? idbranch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.idbranch == null && other.idbranch != null) || (this.idbranch != null && !this.idbranch.equals(other.idbranch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Branch[ idbranch=" + idbranch + " ]";
    }
    
}
