package entities;

import entities.Receipt;
import entities.Treatment;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T18:37:49")
@StaticMetamodel(Medicalservice.class)
public class Medicalservice_ { 

    public static volatile SingularAttribute<Medicalservice, Integer> cost;
    public static volatile ListAttribute<Medicalservice, Receipt> receiptList;
    public static volatile SingularAttribute<Medicalservice, String> name;
    public static volatile ListAttribute<Medicalservice, Treatment> treatmentList;
    public static volatile SingularAttribute<Medicalservice, Integer> idmedicalservice;

}