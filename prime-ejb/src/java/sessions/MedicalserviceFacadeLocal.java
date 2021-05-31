/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Medicalservice;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pas
 */
@Local
public interface MedicalserviceFacadeLocal {

    void create(Medicalservice medicalservice);

    void edit(Medicalservice medicalservice);

    void remove(Medicalservice medicalservice);

    Medicalservice find(Object id);

    List<Medicalservice> findAll();

    List<Medicalservice> findRange(int[] range);

    int count();
    
     Integer nextId();
}
