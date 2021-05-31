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
@Table(name = "operations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operations.nextId", query = "SELECT MAX(o.idoperation) FROM Operations o"),
    @NamedQuery(name = "Operations.findAll", query = "SELECT o FROM Operations o"),
    @NamedQuery(name = "Operations.findByIdoperation", query = "SELECT o FROM Operations o WHERE o.idoperation = :idoperation"),
    @NamedQuery(name = "Operations.findByName", query = "SELECT o FROM Operations o WHERE o.name = :name"),
    @NamedQuery(name = "Operations.findByDate", query = "SELECT o FROM Operations o WHERE o.date = :date"),
    @NamedQuery(name = "Operations.findByTime", query = "SELECT o FROM Operations o WHERE o.time = :time"),
    @NamedQuery(name = "Operations.findByTarget", query = "SELECT o FROM Operations o WHERE o.target = :target"),
    @NamedQuery(name = "Operations.findByIpaddress", query = "SELECT o FROM Operations o WHERE o.ipaddress = :ipaddress")})
public class Operations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idoperation")
    private Integer idoperation;
    @Size(max = 254)
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Size(max = 254)
    @Column(name = "target")
    private String target;
    @Size(max = 254)
    @Column(name = "ipaddress")
    private String ipaddress;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private Userr iduser;

    public Operations() {
    }

    public Operations(Integer idoperation) {
        this.idoperation = idoperation;
    }

    public Integer getIdoperation() {
        return idoperation;
    }

    public void setIdoperation(Integer idoperation) {
        this.idoperation = idoperation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public Userr getIduser() {
        return iduser;
    }

    public void setIduser(Userr iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoperation != null ? idoperation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operations)) {
            return false;
        }
        Operations other = (Operations) object;
        if ((this.idoperation == null && other.idoperation != null) || (this.idoperation != null && !this.idoperation.equals(other.idoperation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Operations[ idoperation=" + idoperation + " ]";
    }
    
}
