package entities;

import entities.Patient;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Parameter.class)
public class Parameter_ { 

    public static volatile SingularAttribute<Parameter, Integer> date;
    public static volatile SingularAttribute<Parameter, Patient> idpatient;
    public static volatile SingularAttribute<Parameter, Integer> idparameter;
    public static volatile SingularAttribute<Parameter, String> heartbeat;
    public static volatile SingularAttribute<Parameter, String> temperature;
    public static volatile SingularAttribute<Parameter, String> weight;
    public static volatile SingularAttribute<Parameter, String> bloodtension;

}