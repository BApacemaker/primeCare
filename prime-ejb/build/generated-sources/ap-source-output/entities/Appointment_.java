package entities;

import entities.Patient;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Appointment.class)
public class Appointment_ { 

    public static volatile SingularAttribute<Appointment, Date> date;
    public static volatile SingularAttribute<Appointment, Patient> idpatient;
    public static volatile SingularAttribute<Appointment, Integer> idappiontment;
    public static volatile SingularAttribute<Appointment, String> purpose;
    public static volatile SingularAttribute<Appointment, Date> time;
    public static volatile SingularAttribute<Appointment, String> type;
    public static volatile SingularAttribute<Appointment, String> email;

}