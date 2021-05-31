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
@Table(name = "userr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findByLoginPwd", query = "SELECT u FROM Userr u WHERE u.login = :login AND u.pwd = :pwd"),
    @NamedQuery(name = "User.nextId", query = "SELECT MAX(u.iduser) FROM Userr u"),
    @NamedQuery(name = "Userr.findAll", query = "SELECT u FROM Userr u"),
    @NamedQuery(name = "Userr.findByIduser", query = "SELECT u FROM Userr u WHERE u.iduser = :iduser"),
    @NamedQuery(name = "Userr.findByName", query = "SELECT u FROM Userr u WHERE u.name = :name"),
    @NamedQuery(name = "Userr.findByState", query = "SELECT u FROM Userr u WHERE u.status = :status"),
    @NamedQuery(name = "Userr.findByLogin", query = "SELECT u FROM Userr u WHERE u.login = :login"),
    @NamedQuery(name = "Userr.findByPwd", query = "SELECT u FROM Userr u WHERE u.pwd = :pwd")})
public class Userr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iduser")
    private Integer iduser;
    @Size(max = 254)
    @Column(name = "name")
    private String name;
    @Size(max = 254)
    @Column(name = "status")
    private String status;
    @Size(max = 254)
    @Column(name = "login")
    private String login;
    @Size(max = 254)
    @Column(name = "pwd")
    private String pwd;
    @JoinColumn(name = "iddepartment", referencedColumnName = "iddepartment")
    @ManyToOne(optional = false)
    private Department iddepartment;
    @JoinColumn(name = "idusergroup", referencedColumnName = "idusergroup")
    @ManyToOne(optional = false)
    private Usergroup idusergroup;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Operations> operationsList;

    public Userr() {
    }

    public Userr(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Department getIddepartment() {
        return iddepartment;
    }

    public void setIddepartment(Department iddepartment) {
        this.iddepartment = iddepartment;
    }

    public Usergroup getIdusergroup() {
        return idusergroup;
    }

    public void setIdusergroup(Usergroup idusergroup) {
        this.idusergroup = idusergroup;
    }

    @XmlTransient
    public List<Operations> getOperationsList() {
        return operationsList;
    }

    public void setOperationsList(List<Operations> operationsList) {
        this.operationsList = operationsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userr)) {
            return false;
        }
        Userr other = (Userr) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Userr[ iduser=" + iduser + " ]";
    }
    
}
