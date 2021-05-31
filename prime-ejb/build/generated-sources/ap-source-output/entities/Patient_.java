package entities;

import entities.Admission;
import entities.Appointment;
import entities.Consultation;
import entities.Medicaltest;
import entities.Parameter;
import entities.Receipt;
import entities.Surgery;
import entities.Transfer;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Patient.class)
public class Patient_ { 

    public static volatile SingularAttribute<Patient, String> gender;
    public static volatile SingularAttribute<Patient, String> matricule;
    public static volatile ListAttribute<Patient, Receipt> receiptList;
    public static volatile ListAttribute<Patient, Appointment> appointmentList;
    public static volatile SingularAttribute<Patient, String> guidenumber;
    public static volatile ListAttribute<Patient, Consultation> consultationList;
    public static volatile SingularAttribute<Patient, Integer> idpatient;
    public static volatile ListAttribute<Patient, Transfer> transferList;
    public static volatile SingularAttribute<Patient, String> guidemail;
    public static volatile SingularAttribute<Patient, String> phone;
    public static volatile SingularAttribute<Patient, String> name;
    public static volatile ListAttribute<Patient, Parameter> parameterList;
    public static volatile ListAttribute<Patient, Surgery> surgeryList;
    public static volatile SingularAttribute<Patient, String> location;
    public static volatile ListAttribute<Patient, Medicaltest> medicaltestList;
    public static volatile SingularAttribute<Patient, String> email;
    public static volatile SingularAttribute<Patient, String> age;
    public static volatile ListAttribute<Patient, Admission> admissionList;

}