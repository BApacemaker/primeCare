package entities;

import entities.Department;
import entities.Operations;
import entities.Usergroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Userr.class)
public class Userr_ { 

    public static volatile SingularAttribute<Userr, Integer> iduser;
    public static volatile SingularAttribute<Userr, Usergroup> idusergroup;
    public static volatile ListAttribute<Userr, Operations> operationsList;
    public static volatile SingularAttribute<Userr, String> name;
    public static volatile SingularAttribute<Userr, String> login;
    public static volatile SingularAttribute<Userr, String> pwd;
    public static volatile SingularAttribute<Userr, Department> iddepartment;
    public static volatile SingularAttribute<Userr, String> status;

}