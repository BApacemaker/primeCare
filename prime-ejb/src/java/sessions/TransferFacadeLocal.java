/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Transfer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pas
 */
@Local
public interface TransferFacadeLocal {

    void create(Transfer transfer);

    void edit(Transfer transfer);

    void remove(Transfer transfer);

    Transfer find(Object id);

    List<Transfer> findAll();

    List<Transfer> findRange(int[] range);

    int count();
    
     Integer nextId();
}
