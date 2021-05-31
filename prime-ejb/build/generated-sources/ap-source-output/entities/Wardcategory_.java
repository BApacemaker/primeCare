package entities;

import entities.Ward;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Wardcategory.class)
public class Wardcategory_ { 

    public static volatile SingularAttribute<Wardcategory, Integer> idwardcategory;
    public static volatile SingularAttribute<Wardcategory, String> rank;
    public static volatile ListAttribute<Wardcategory, Ward> wardList;
    public static volatile SingularAttribute<Wardcategory, String> prize;

}