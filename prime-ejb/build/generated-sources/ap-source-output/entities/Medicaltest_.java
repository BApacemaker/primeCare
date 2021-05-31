package entities;

import entities.Patient;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Medicaltest.class)
public class Medicaltest_ { 

    public static volatile SingularAttribute<Medicaltest, String> ressult;
    public static volatile SingularAttribute<Medicaltest, Patient> idpatient;
    public static volatile SingularAttribute<Medicaltest, Integer> idmedicaltest;
    public static volatile SingularAttribute<Medicaltest, String> description;
    public static volatile SingularAttribute<Medicaltest, String> type;

}