/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Usergroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pas
 */
@Local
public interface UsergroupFacadeLocal {

    void create(Usergroup usergroup);

    void edit(Usergroup usergroup);

    void remove(Usergroup usergroup);

    Usergroup find(Object id);

    List<Usergroup> findAll();

    List<Usergroup> findRange(int[] range);

    int count();
    
    Integer nextId();
}
