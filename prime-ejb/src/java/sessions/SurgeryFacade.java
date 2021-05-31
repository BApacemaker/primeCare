/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Surgery;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pas
 */
@Stateless
public class SurgeryFacade extends AbstractFacade<Surgery> implements SurgeryFacadeLocal {

    @PersistenceContext(unitName = "prime-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SurgeryFacade() {
        super(Surgery.class);
    }
    
        @Override
    public Integer nextId(){
    
    try{
       Query query = em.createNamedQuery("Surgery.nextId");
       return((Integer) query.getSingleResult()) + 1;
  
     }catch(Exception e){
    
        return 1;
      }
    
    }
}
