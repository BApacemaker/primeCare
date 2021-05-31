/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Medicaltest;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pas
 */
@Stateless
public class MedicaltestFacade extends AbstractFacade<Medicaltest> implements MedicaltestFacadeLocal {

    @PersistenceContext(unitName = "prime-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicaltestFacade() {
        super(Medicaltest.class);
    }
    
            @Override
    public Integer nextId(){
    
    try{
       Query query = em.createNamedQuery("Medicaltest.nextId");
       return((Integer) query.getSingleResult()) + 1;
  
     }catch(Exception e){
    
        return 1;
      }
    
    }
}
