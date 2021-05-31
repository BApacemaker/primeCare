package entities;

import entities.Discharge;
import entities.Patient;
import entities.Treatment;
import entities.Ward;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Admission.class)
public class Admission_ { 

    public static volatile SingularAttribute<Admission, Date> date;
    public static volatile SingularAttribute<Admission, Patient> idpatient;
    public static volatile SingularAttribute<Admission, Integer> idadmission;
    public static volatile SingularAttribute<Admission, Ward> idward;
    public static volatile SingularAttribute<Admission, Date> dateline;
    public static volatile SingularAttribute<Admission, String> purpose;
    public static volatile ListAttribute<Admission, Treatment> treatmentList;
    public static volatile ListAttribute<Admission, Discharge> dischargeList;
    public static volatile SingularAttribute<Admission, Date> time;

}