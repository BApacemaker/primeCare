/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Medicaltest;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pas
 */
@Local
public interface MedicaltestFacadeLocal {

    void create(Medicaltest medicaltest);

    void edit(Medicaltest medicaltest);

    void remove(Medicaltest medicaltest);

    Medicaltest find(Object id);

    List<Medicaltest> findAll();

    List<Medicaltest> findRange(int[] range);

    int count();
    
     Integer nextId();
}
