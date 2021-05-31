package entities;

import entities.Admission;
import entities.Bed;
import entities.Branch;
import entities.Wardcategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Ward.class)
public class Ward_ { 

    public static volatile SingularAttribute<Ward, Wardcategory> idwardcategory;
    public static volatile SingularAttribute<Ward, Integer> idward;
    public static volatile SingularAttribute<Ward, String> code;
    public static volatile SingularAttribute<Ward, Branch> idbranch;
    public static volatile SingularAttribute<Ward, String> name;
    public static volatile SingularAttribute<Ward, String> state;
    public static volatile ListAttribute<Ward, Bed> bedList;
    public static volatile ListAttribute<Ward, Admission> admissionList;

}