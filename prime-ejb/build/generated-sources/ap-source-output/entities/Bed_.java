package entities;

import entities.Ward;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Bed.class)
public class Bed_ { 

    public static volatile SingularAttribute<Bed, Integer> idbed;
    public static volatile SingularAttribute<Bed, String> number;
    public static volatile SingularAttribute<Bed, Ward> idward;
    public static volatile SingularAttribute<Bed, String> status;

}