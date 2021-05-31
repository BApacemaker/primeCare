/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Receipt;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pas
 */
@Local
public interface ReceiptFacadeLocal {

    void create(Receipt receipt);

    void edit(Receipt receipt);

    void remove(Receipt receipt);

    Receipt find(Object id);

    List<Receipt> findAll();

    List<Receipt> findRange(int[] range);

    int count();
    
     Integer nextId();
    
}
