/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Admission;
import entities.Discharge;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pas
 */
@Stateless
public class AdmissionFacade extends AbstractFacade<Admission> implements AdmissionFacadeLocal {

    @PersistenceContext(unitName = "prime-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdmissionFacade() {
        super(Admission.class);
    }
    
        
      @Override
    public Integer nextId(){
    
    try{
       Query query = em.createNamedQuery("Admission.nextId");
       return((Integer) query.getSingleResult()) + 1;
  
     }catch(Exception e){
    
        return 1;
      }
    
    }
    
     @Override
    public Admission findbyadm(String purpose, Date date ,Date time) {
        Query query = em.createNamedQuery("Admission.findbyadm");
        query.setParameter("purpose", purpose).setParameter("date", date).setParameter("time", time);
        try {
            return (Admission) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
  
