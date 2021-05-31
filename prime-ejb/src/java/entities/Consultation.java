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
@Table(name = "consultation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultation.nextId", query = "SELECT MAX(c.idconsultation) FROM Consultation c"),
    @NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c"),
    @NamedQuery(name = "Consultation.findByIdconsultation", query = "SELECT c FROM Consultation c WHERE c.idconsultation = :idconsultation"),
    @NamedQuery(name = "Consultation.findByDescription", query = "SELECT c FROM Consultation c WHERE c.description = :description"),
    @NamedQuery(name = "Consultation.findByType", query = "SELECT c FROM Consultation c WHERE c.type = :type"),
    @NamedQuery(name = "Consultation.findByDiagnose", query = "SELECT c FROM Consultation c WHERE c.diagnose = :diagnose")})
public class Consultation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idconsultation")
    private Integer idconsultation;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @Size(max = 254)
    @Column(name = "type")
    private String type;
    @Size(max = 254)
    @Column(name = "diagnose")
    private String diagnose;
    @JoinColumn(name = "idpatient", referencedColumnName = "idpatient")
    @ManyToOne
    private Patient idpatient;

    public Consultation() {
    }

    public Consultation(Integer idconsultation) {
        this.idconsultation = idconsultation;
    }

    public Integer getIdconsultation() {
        return idconsultation;
    }

    public void setIdconsultation(Integer idconsultation) {
        this.idconsultation = idconsultation;
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

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
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
        hash += (idconsultation != null ? idconsultation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        if ((this.idconsultation == null && other.idconsultation != null) || (this.idconsultation != null && !this.idconsultation.equals(other.idconsultation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Consultation[ idconsultation=" + idconsultation + " ]";
    }
    
}
