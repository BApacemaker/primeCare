package entities;

import entities.Menu;
import entities.Userr;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Usergroup.class)
public class Usergroup_ { 

    public static volatile ListAttribute<Usergroup, Menu> menuList;
    public static volatile SingularAttribute<Usergroup, Integer> idusergroup;
    public static volatile ListAttribute<Usergroup, Userr> userrList;
    public static volatile SingularAttribute<Usergroup, String> name;

}