/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Admission;
import entities.Patient;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pas
 */
@Local
public interface AdmissionFacadeLocal {

    void create(Admission admission);

    void edit(Admission admission);

    void remove(Admission admission);

    Admission find(Object id);

    List<Admission> findAll();

    List<Admission> findRange(int[] range);

    int count();
    
    Integer nextId();
    
    Admission findbyadm(String purpose, Date date ,Date time);
}
