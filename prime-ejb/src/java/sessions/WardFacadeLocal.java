/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Ward;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pas
 */
@Local
public interface WardFacadeLocal {

    void create(Ward ward);

    void edit(Ward ward);

    void remove(Ward ward);

    Ward find(Object id);

    List<Ward> findAll();

    List<Ward> findRange(int[] range);

    int count();
    
     Integer nextId();
}
