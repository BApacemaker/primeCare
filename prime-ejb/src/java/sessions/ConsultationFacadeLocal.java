/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Consultation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pas
 */
@Local
public interface ConsultationFacadeLocal {

    void create(Consultation consultation);

    void edit(Consultation consultation);

    void remove(Consultation consultation);

    Consultation find(Object id);

    List<Consultation> findAll();

    List<Consultation> findRange(int[] range);

    int count();
    
    Integer nextId();
}
