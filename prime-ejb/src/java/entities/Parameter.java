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
@Table(name = "parameter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parameter.nextId", query = "SELECT MAX(p.idparameter) FROM Parameter p"),
    @NamedQuery(name = "Parameter.findAll", query = "SELECT p FROM Parameter p"),
    @NamedQuery(name = "Parameter.findByIdparameter", query = "SELECT p FROM Parameter p WHERE p.idparameter = :idparameter"),
    @NamedQuery(name = "Parameter.findByTemperature", query = "SELECT p FROM Parameter p WHERE p.temperature = :temperature"),
    @NamedQuery(name = "Parameter.findByBloodtension", query = "SELECT p FROM Parameter p WHERE p.bloodtension = :bloodtension"),
    @NamedQuery(name = "Parameter.findByWeight", query = "SELECT p FROM Parameter p WHERE p.weight = :weight"),
    @NamedQuery(name = "Parameter.findByDate", query = "SELECT p FROM Parameter p WHERE p.date = :date"),
    @NamedQuery(name = "Parameter.findByHeartbeat", query = "SELECT p FROM Parameter p WHERE p.heartbeat = :heartbeat")})
public class Parameter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idparameter")
    private Integer idparameter;
    @Size(max = 254)
    @Column(name = "temperature")
    private String temperature;
    @Size(max = 254)
    @Column(name = "bloodtension")
    private String bloodtension;
    @Size(max = 254)
    @Column(name = "weight")
    private String weight;
    @Column(name = "date")
    private Integer date;
    @Size(max = 254)
    @Column(name = "heartbeat")
    private String heartbeat;
    @JoinColumn(name = "idpatient", referencedColumnName = "idpatient")
    @ManyToOne
    private Patient idpatient;

    public Parameter() {
    }

    public Parameter(Integer idparameter) {
        this.idparameter = idparameter;
    }

    public Integer getIdparameter() {
        return idparameter;
    }

    public void setIdparameter(Integer idparameter) {
        this.idparameter = idparameter;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getBloodtension() {
        return bloodtension;
    }

    public void setBloodtension(String bloodtension) {
        this.bloodtension = bloodtension;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(String heartbeat) {
        this.heartbeat = heartbeat;
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
        hash += (idparameter != null ? idparameter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parameter)) {
            return false;
        }
        Parameter other = (Parameter) object;
        if ((this.idparameter == null && other.idparameter != null) || (this.idparameter != null && !this.idparameter.equals(other.idparameter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Parameter[ idparameter=" + idparameter + " ]";
    }
    
}
