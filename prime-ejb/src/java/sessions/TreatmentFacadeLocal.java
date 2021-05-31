/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Treatment;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pas
 */
@Local
public interface TreatmentFacadeLocal {

    void create(Treatment treatment);

    void edit(Treatment treatment);

    void remove(Treatment treatment);

    Treatment find(Object id);

    List<Treatment> findAll();

    List<Treatment> findRange(int[] range);

    int count();
    
     Integer nextId();
     
     Treatment findbytreate(String detail, Date date ,Date time);
}
