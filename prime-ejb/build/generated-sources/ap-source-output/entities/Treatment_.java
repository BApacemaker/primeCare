package entities;

import entities.Admission;
import entities.Medicalservice;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Treatment.class)
public class Treatment_ { 

    public static volatile SingularAttribute<Treatment, Date> date;
    public static volatile SingularAttribute<Treatment, Admission> idadmission;
    public static volatile SingularAttribute<Treatment, Integer> idtreatment;
    public static volatile SingularAttribute<Treatment, String> detail;
    public static volatile SingularAttribute<Treatment, Date> time;
    public static volatile SingularAttribute<Treatment, Medicalservice> idmedicalservice;

}