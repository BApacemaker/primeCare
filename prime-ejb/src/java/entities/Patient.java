
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "patient")
@XmlRootElement
@NamedQueries({    
    @NamedQuery(name = "Admission.admdate", query = "SELECT p FROM Admission p WHERE p.date >= p.dateline"),
    @NamedQuery(name = "Patient.findbycheck", query = "SELECT p FROM Patient p WHERE p.phone = :phone AND p.email = :email AND p.guidemail = :guidemail AND p.guidenumber = :guidenumber"),
    @NamedQuery(name = "Patient.nextId", query = "SELECT MAX(p.idpatient) FROM Patient p"),
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByIdpatient", query = "SELECT p FROM Patient p WHERE p.idpatient = :idpatient"),
    @NamedQuery(name = "Patient.findByName", query = "SELECT p FROM Patient p WHERE p.name = :name"),
    @NamedQuery(name = "Patient.findByLocation", query = "SELECT p FROM Patient p WHERE p.location = :location"),
    @NamedQuery(name = "Patient.findByEmail", query = "SELECT p FROM Patient p WHERE p.email = :email"),
    @NamedQuery(name = "Patient.findByGender", query = "SELECT p FROM Patient p WHERE p.gender = :gender"),
    @NamedQuery(name = "Patient.findByAge", query = "SELECT p FROM Patient p WHERE p.age = :age"),
    @NamedQuery(name = "Patient.findByMatricule", query = "SELECT p FROM Patient p WHERE p.matricule = :matricule"),
    @NamedQuery(name = "Patient.findByPhone", query = "SELECT p FROM Patient p WHERE p.phone = :phone")})
public class Patient implements Serializable {

    @Size(max = 2147483647)
    @Column(name = "guidemail")
    private String guidemail;
    @Size(max = 2147483647)
    @Column(name = "guidenumber")
    private String guidenumber;



    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpatient")
    private Integer idpatient;
    @Size(max = 254)
    @Column(name = "name")
    private String name;
    @Size(max = 254)
    @Column(name = "location")
    private String location;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "email")
    private String email;
    @Size(max = 254)
    @Column(name = "gender")
    private String gender;
    @Size(max = 254)
    @Column(name = "age")
    private String age;
    @Size(max = 254)
    @Column(name = "matricule")
    private String matricule;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "phone")
    private String phone;
    @OneToMany(mappedBy = "idpatient")
    private List<Medicaltest> medicaltestList;
    @OneToMany(mappedBy = "idpatient")
    private List<Appointment> appointmentList;
    @OneToMany(mappedBy = "idpatient")
    private List<Admission> admissionList;
    @OneToMany(mappedBy = "idpatient")
    private List<Transfer> transferList;
    @OneToMany(mappedBy = "idpatient")
    private List<Parameter> parameterList;
    @OneToMany(mappedBy = "idpatient")
    private List<Receipt> receiptList;
    @OneToMany(mappedBy = "idpatient")
    private List<Consultation> consultationList;
    @OneToMany(mappedBy = "idpatient")
    private List<Surgery> surgeryList;

    public Patient() {
    }

    public Patient(Integer idpatient) {
        this.idpatient = idpatient;
    }

    public Integer getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(Integer idpatient) {
        this.idpatient = idpatient;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlTransient
    public List<Medicaltest> getMedicaltestList() {
        return medicaltestList;
    }

    public void setMedicaltestList(List<Medicaltest> medicaltestList) {
        this.medicaltestList = medicaltestList;
    }

    @XmlTransient
    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @XmlTransient
    public List<Admission> getAdmissionList() {
        return admissionList;
    }

    public void setAdmissionList(List<Admission> admissionList) {
        this.admissionList = admissionList;
    }

    @XmlTransient
    public List<Transfer> getTransferList() {
        return transferList;
    }

    public void setTransferList(List<Transfer> transferList) {
        this.transferList = transferList;
    }

    @XmlTransient
    public List<Parameter> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<Parameter> parameterList) {
        this.parameterList = parameterList;
    }

    @XmlTransient
    public List<Receipt> getReceiptList() {
        return receiptList;
    }

    public void setReceiptList(List<Receipt> receiptList) {
        this.receiptList = receiptList;
    }

    @XmlTransient
    public List<Consultation> getConsultationList() {
        return consultationList;
    }

    public void setConsultationList(List<Consultation> consultationList) {
        this.consultationList = consultationList;
    }

    @XmlTransient
    public List<Surgery> getSurgeryList() {
        return surgeryList;
    }

    public void setSurgeryList(List<Surgery> surgeryList) {
        this.surgeryList = surgeryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpatient != null ? idpatient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.idpatient == null && other.idpatient != null) || (this.idpatient != null && !this.idpatient.equals(other.idpatient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Patient[ idpatient=" + idpatient + " ]";
    }

 

    public String getGuidemail() {
        return guidemail;
    }

    public void setGuidemail(String guidemail) {
        this.guidemail = guidemail;
    }

    public String getGuidenumber() {
        return guidenumber;
    }

    public void setGuidenumber(String guidenumber) {
        this.guidenumber = guidenumber;
    }

  
    
}
