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
import javax.persistence.ManyToMany;
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
@Table(name = "usergroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usergroup.nextId", query = "SELECT MAX(u.idusergroup) FROM Usergroup u"),
    @NamedQuery(name = "Usergroup.findAll", query = "SELECT u FROM Usergroup u"),
    @NamedQuery(name = "Usergroup.findByIdusergroup", query = "SELECT u FROM Usergroup u WHERE u.idusergroup = :idusergroup"),
    @NamedQuery(name = "Usergroup.findByName", query = "SELECT u FROM Usergroup u WHERE u.name = :name")})
public class Usergroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusergroup")
    private Integer idusergroup;
    @Size(max = 254)
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "usergroupList")
    private List<Menu> menuList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusergroup")
    private List<Userr> userrList;

    public Usergroup() {
    }

    public Usergroup(Integer idusergroup) {
        this.idusergroup = idusergroup;
    }

   public Integer getIdusergroup() {
        return idusergroup;
    }

    public void setIdusergroup(Integer idusergroup) {
        this.idusergroup = idusergroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @XmlTransient
    public List<Userr> getUserrList() {
        return userrList;
    }

    public void setUserrList(List<Userr> userrList) {
        this.userrList = userrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusergroup != null ? idusergroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usergroup)) {
            return false;
        }
        Usergroup other = (Usergroup) object;
        if ((this.idusergroup == null && other.idusergroup != null) || (this.idusergroup != null && !this.idusergroup.equals(other.idusergroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usergroup[ idusergroup=" + idusergroup + " ]";
    }
    
}
