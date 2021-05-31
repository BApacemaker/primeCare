package entities;

import entities.Branch;
import entities.Patient;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Transfer.class)
public class Transfer_ { 

    public static volatile SingularAttribute<Transfer, Date> date;
    public static volatile SingularAttribute<Transfer, Patient> idpatient;
    public static volatile SingularAttribute<Transfer, Branch> idbranch;
    public static volatile SingularAttribute<Transfer, Integer> idtransfer;
    public static volatile SingularAttribute<Transfer, String> purpose;
    public static volatile SingularAttribute<Transfer, String> patcondition;
    public static volatile SingularAttribute<Transfer, Date> time;

}