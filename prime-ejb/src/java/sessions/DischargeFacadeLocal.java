
package sessions;

import entities.Discharge;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pas
 */
@Local
public interface DischargeFacadeLocal {

    void create(Discharge discharge);

    void edit(Discharge discharge);

    void remove(Discharge discharge);

    Discharge find(Object id);

    List<Discharge> findAll();

    List<Discharge> findRange(int[] range);

    int count();
    
    Integer nextId();
    
    List<Date> dischargeDate();
    
    Discharge findbydisch(String reason, Date date ,Date time);
}
