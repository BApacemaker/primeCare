package entities;

import entities.Medicalservice;
import entities.Patient;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Receipt.class)
public class Receipt_ { 

    public static volatile SingularAttribute<Receipt, Date> date;
    public static volatile SingularAttribute<Receipt, Patient> idpatient;
    public static volatile SingularAttribute<Receipt, String> clinicname;
    public static volatile SingularAttribute<Receipt, Integer> idreceipt;
    public static volatile SingularAttribute<Receipt, Medicalservice> idmedicalservice;
    public static volatile SingularAttribute<Receipt, String> branchname;

}