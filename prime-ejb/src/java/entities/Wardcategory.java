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
@Table(name = "wardcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wardcategory.nextId", query = "SELECT MAX(w.idwardcategory) FROM Wardcategory w"),
    @NamedQuery(name = "Wardcategory.findAll", query = "SELECT w FROM Wardcategory w"),
    @NamedQuery(name = "Wardcategory.findByIdwardcategory", query = "SELECT w FROM Wardcategory w WHERE w.idwardcategory = :idwardcategory"),
    @NamedQuery(name = "Wardcategory.findByRank", query = "SELECT w FROM Wardcategory w WHERE w.rank = :rank"),
    @NamedQuery(name = "Wardcategory.findByPrize", query = "SELECT w FROM Wardcategory w WHERE w.prize = :prize")})
public class Wardcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idwardcategory")
    private Integer idwardcategory;
    @Size(max = 254)
    @Column(name = "rank")
    private String rank;
    @Size(max = 254)
    @Column(name = "prize")
    private String prize;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idwardcategory")
    private List<Ward> wardList;

    public Wardcategory() {
    }

    public Wardcategory(Integer idwardcategory) {
        this.idwardcategory = idwardcategory;
    }

    public Integer getIdwardcategory() {
        return idwardcategory;
    }

    public void setIdwardcategory(Integer idwardcategory) {
        this.idwardcategory = idwardcategory;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    @XmlTransient
    public List<Ward> getWardList() {
        return wardList;
    }

    public void setWardList(List<Ward> wardList) {
        this.wardList = wardList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idwardcategory != null ? idwardcategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wardcategory)) {
            return false;
        }
        Wardcategory other = (Wardcategory) object;
        if ((this.idwardcategory == null && other.idwardcategory != null) || (this.idwardcategory != null && !this.idwardcategory.equals(other.idwardcategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Wardcategory[ idwardcategory=" + idwardcategory + " ]";
    }
    
}
