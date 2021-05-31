package entities;

import entities.Userr;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Operations.class)
public class Operations_ { 

    public static volatile SingularAttribute<Operations, Date> date;
    public static volatile SingularAttribute<Operations, String> ipaddress;
    public static volatile SingularAttribute<Operations, Userr> iduser;
    public static volatile SingularAttribute<Operations, Integer> idoperation;
    public static volatile SingularAttribute<Operations, String> name;
    public static volatile SingularAttribute<Operations, Date> time;
    public static volatile SingularAttribute<Operations, String> target;

}