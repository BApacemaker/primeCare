/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Surgery;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pas
 */
@Local
public interface SurgeryFacadeLocal {

    void create(Surgery surgery);

    void edit(Surgery surgery);

    void remove(Surgery surgery);

    Surgery find(Object id);

    List<Surgery> findAll();

    List<Surgery> findRange(int[] range);

    int count();
    
    Integer nextId();
}
