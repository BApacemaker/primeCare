package entities;

import entities.Department;
import entities.Transfer;
import entities.Ward;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Branch.class)
public class Branch_ { 

    public static volatile ListAttribute<Branch, Transfer> transferList;
    public static volatile SingularAttribute<Branch, Integer> idbranch;
    public static volatile SingularAttribute<Branch, String> name;
    public static volatile SingularAttribute<Branch, String> location;
    public static volatile ListAttribute<Branch, Ward> wardList;
    public static volatile ListAttribute<Branch, Department> departmentList;

}