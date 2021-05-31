/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pas
 */
@Entity
@Table(name = "bed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bed.nextId", query = "SELECT MAX(b.idbed) FROM Bed b"),
    @NamedQuery(name = "Bed.findAll", query = "SELECT b FROM Bed b"),
    @NamedQuery(name = "Bed.findByIdbed", query = "SELECT b FROM Bed b WHERE b.idbed = :idbed"),
    @NamedQuery(name = "Bed.findByStatus", query = "SELECT b FROM Bed b WHERE b.status = :status"),
    @NamedQuery(name = "Bed.findByNumber", query = "SELECT b FROM Bed b WHERE b.number = :number")})
public class Bed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbed")
    private Integer idbed;
    @Size(max = 254)
    @Column(name = "status")
    private String status;
    @Size(max = 254)
    @Column(name = "number")
    private String number;
    @JoinColumn(name = "idward", referencedColumnName = "idward")
    @ManyToOne
    private Ward idward;

    public Bed() {
    }

    public Bed(Integer idbed) {
        this.idbed = idbed;
    }

    public Integer getIdbed() {
        return idbed;
    }

    public void setIdbed(Integer idbed) {
        this.idbed = idbed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Ward getIdward() {
        return idward;
    }

    public void setIdward(Ward idward) {
        this.idward = idward;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbed != null ? idbed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bed)) {
            return false;
        }
        Bed other = (Bed) object;
        if ((this.idbed == null && other.idbed != null) || (this.idbed != null && !this.idbed.equals(other.idbed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bed[ idbed=" + idbed + " ]";
    }
    
}
