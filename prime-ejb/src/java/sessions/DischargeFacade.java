
package sessions;

import entities.Discharge;
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
public class DischargeFacade extends AbstractFacade<Discharge> implements DischargeFacadeLocal {

    @PersistenceContext(unitName = "prime-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DischargeFacade() {
        super(Discharge.class);
    }
    
             @Override
    public Integer nextId(){
    
    try{
       Query query = em.createNamedQuery("Discharge.nextId");
       return((Integer) query.getSingleResult()) + 1;
  
     }catch(Exception e){
    
        return 1;
      }
    
    }
      
    @Override
    public List<Date> dischargeDate(){
    
    try{
       Query query = em.createNamedQuery("Discharge.findbydischargeDate");
       return((List<Date>) query.getSingleResult());
  
     }catch(Exception e){
         
        return dischargeDate();
     
     }
      
    }
    
       @Override
    public Discharge findbydisch(String reason, Date date ,Date time) {
        Query query = em.createNamedQuery("Discharge.findbydisch");
        query.setParameter("reason", reason).setParameter("date", date).setParameter("time", time);
        try {
            return (Discharge) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
