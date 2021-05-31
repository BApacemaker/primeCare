/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Wardcategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pas
 */
@Local
public interface WardcategoryFacadeLocal {

    void create(Wardcategory wardcategory);

    void edit(Wardcategory wardcategory);

    void remove(Wardcategory wardcategory);

    Wardcategory find(Object id);

    List<Wardcategory> findAll();

    List<Wardcategory> findRange(int[] range);

    int count();
    
     Integer nextId();
}
