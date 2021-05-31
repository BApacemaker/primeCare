package entities;

import entities.Patient;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Surgery.class)
public class Surgery_ { 

    public static volatile SingularAttribute<Surgery, Patient> idpatient;
    public static volatile SingularAttribute<Surgery, String> name;
    public static volatile SingularAttribute<Surgery, String> description;
    public static volatile SingularAttribute<Surgery, String> cause;
    public static volatile SingularAttribute<Surgery, Integer> idsurgery;

}