package entities;

import entities.Menu;
import entities.Usergroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile ListAttribute<Menu, Menu> menuList;
    public static volatile SingularAttribute<Menu, String> code;
    public static volatile ListAttribute<Menu, Usergroup> usergroupList;
    public static volatile SingularAttribute<Menu, String> name;
    public static volatile SingularAttribute<Menu, Integer> idmenu;
    public static volatile SingularAttribute<Menu, Menu> menIdmenu;

}