/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Treatment;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pas
 */
@Stateless
public class TreatmentFacade extends AbstractFacade<Treatment> implements TreatmentFacadeLocal {

    @PersistenceContext(unitName = "prime-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TreatmentFacade() {
        super(Treatment.class);
    }
    
    @Override
    public Integer nextId(){
    
    try{
       Query query = em.createNamedQuery("Treatment.nextId");
       return((Integer) query.getSingleResult()) + 1;
  
     }catch(Exception e){
    
        return 1;
      }
    
    }
    

     @Override
    public Treatment findbytreate(String detail, Date date ,Date time) {
        Query query = em.createNamedQuery("Treatment.findbytreate");
        query.setParameter("detail", detail).setParameter("date", date).setParameter("time", time);
        try {
            return (Treatment) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
