/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Bed;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pas
 */
@Local
public interface BedFacadeLocal {

    void create(Bed bed);

    void edit(Bed bed);

    void remove(Bed bed);

    Bed find(Object id);

    List<Bed> findAll();

    List<Bed> findRange(int[] range);

    int count();
    
    Integer nextId();
}
