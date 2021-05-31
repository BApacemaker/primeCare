/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Admission;
import entities.Patient;
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
public class PatientFacade extends AbstractFacade<Patient> implements PatientFacadeLocal {

    @PersistenceContext(unitName = "prime-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PatientFacade() {
        super(Patient.class);
    }
    
          @Override
    public Integer nextId(){
    
    try{
       Query query = em.createNamedQuery("Patient.nextId");
       return((Integer) query.getSingleResult()) + 1;
  
     }catch(Exception e){
    
        return 1;
      }
    
    }
        
//    
//    @Override
//    public Patient findByPhone(String phone){
//        Query query = em.createNamedQuery("Patient.findByPhone");
//        query.setParameter("phone", phone);
//        try{
//        return (Patient)query.getSingleResult();
//        }catch(Exception e){
//            e.printStackTrace();
//            return null;
//            
//        }
//        
   @Override
    public Patient findbycheck(String phone, String email ,String guidemail, String guidenumber) {
        Query query = em.createNamedQuery("Patient.findbycheck");
        query.setParameter("phone", phone).setParameter("email", email).setParameter("guidemail", guidemail).setParameter("guidenumber", guidenumber);
        try {
            return (Patient) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
      
    @Override
    public List<Admission> admdate(){
    Query q = em.createNamedQuery("Admission.admdate");
    try{
       
       return ((List<Admission>) q.getResultList());
  
     }catch(Exception e){
            e.printStackTrace();
            return null;
            
        }
      
    }

}