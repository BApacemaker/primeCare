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
@Table(name = "medicaltest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicaltest.nextId", query = "SELECT MAX(m.idmedicaltest) FROM Medicaltest m"),
    @NamedQuery(name = "Medicaltest.findAll", query = "SELECT m FROM Medicaltest m"),
    @NamedQuery(name = "Medicaltest.findByIdmedicaltest", query = "SELECT m FROM Medicaltest m WHERE m.idmedicaltest = :idmedicaltest"),
    @NamedQuery(name = "Medicaltest.findByDescription", query = "SELECT m FROM Medicaltest m WHERE m.description = :description"),
    @NamedQuery(name = "Medicaltest.findByType", query = "SELECT m FROM Medicaltest m WHERE m.type = :type"),
    @NamedQuery(name = "Medicaltest.findByRessult", query = "SELECT m FROM Medicaltest m WHERE m.ressult = :ressult")})
public class Medicaltest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmedicaltest")
    private Integer idmedicaltest;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @Size(max = 254)
    @Column(name = "type")
    private String type;
    @Size(max = 254)
    @Column(name = "ressult")
    private String ressult;
    @JoinColumn(name = "idpatient", referencedColumnName = "idpatient")
    @ManyToOne
    private Patient idpatient;

    public Medicaltest() {
    }

    public Medicaltest(Integer idmedicaltest) {
        this.idmedicaltest = idmedicaltest;
    }

    public Integer getIdmedicaltest() {
        return idmedicaltest;
    }

    public void setIdmedicaltest(Integer idmedicaltest) {
        this.idmedicaltest = idmedicaltest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRessult() {
        return ressult;
    }

    public void setRessult(String ressult) {
        this.ressult = ressult;
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
        hash += (idmedicaltest != null ? idmedicaltest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicaltest)) {
            return false;
        }
        Medicaltest other = (Medicaltest) object;
        if ((this.idmedicaltest == null && other.idmedicaltest != null) || (this.idmedicaltest != null && !this.idmedicaltest.equals(other.idmedicaltest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Medicaltest[ idmedicaltest=" + idmedicaltest + " ]";
    }
    
}
