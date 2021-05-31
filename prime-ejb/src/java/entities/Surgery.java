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
@Table(name = "surgery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Surgery.nextId", query = "SELECT MAX(s.idsurgery) FROM Surgery s"),
    @NamedQuery(name = "Surgery.findAll", query = "SELECT s FROM Surgery s"),
    @NamedQuery(name = "Surgery.findByIdsurgery", query = "SELECT s FROM Surgery s WHERE s.idsurgery = :idsurgery"),
    @NamedQuery(name = "Surgery.findByName", query = "SELECT s FROM Surgery s WHERE s.name = :name"),
    @NamedQuery(name = "Surgery.findByDescription", query = "SELECT s FROM Surgery s WHERE s.description = :description"),
    @NamedQuery(name = "Surgery.findByCause", query = "SELECT s FROM Surgery s WHERE s.cause = :cause")})
public class Surgery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsurgery")
    private Integer idsurgery;
    @Size(max = 254)
    @Column(name = "name")
    private String name;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @Size(max = 254)
    @Column(name = "cause")
    private String cause;
    @JoinColumn(name = "idpatient", referencedColumnName = "idpatient")
    @ManyToOne
    private Patient idpatient;

    public Surgery() {
    }

    public Surgery(Integer idsurgery) {
        this.idsurgery = idsurgery;
    }

    public Integer getIdsurgery() {
        return idsurgery;
    }

    public void setIdsurgery(Integer idsurgery) {
        this.idsurgery = idsurgery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
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
        hash += (idsurgery != null ? idsurgery.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Surgery)) {
            return false;
        }
        Surgery other = (Surgery) object;
        if ((this.idsurgery == null && other.idsurgery != null) || (this.idsurgery != null && !this.idsurgery.equals(other.idsurgery))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Surgery[ idsurgery=" + idsurgery + " ]";
    }
    
}
