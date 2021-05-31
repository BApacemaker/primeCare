package entities;

import entities.Patient;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Consultation.class)
public class Consultation_ { 

    public static volatile SingularAttribute<Consultation, Patient> idpatient;
    public static volatile SingularAttribute<Consultation, String> diagnose;
    public static volatile SingularAttribute<Consultation, String> description;
    public static volatile SingularAttribute<Consultation, String> type;
    public static volatile SingularAttribute<Consultation, Integer> idconsultation;

}