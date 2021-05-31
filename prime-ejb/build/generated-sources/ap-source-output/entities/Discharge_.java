package entities;

import entities.Admission;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Discharge.class)
public class Discharge_ { 

    public static volatile SingularAttribute<Discharge, Date> date;
    public static volatile SingularAttribute<Discharge, String> reason;
    public static volatile SingularAttribute<Discharge, Admission> idadmission;
    public static volatile SingularAttribute<Discharge, String> patcondition;
    public static volatile SingularAttribute<Discharge, Date> time;
    public static volatile SingularAttribute<Discharge, Integer> iddischarge;

}