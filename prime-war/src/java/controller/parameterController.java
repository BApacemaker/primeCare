

package controller;


import entities.Parameter;
import entities.Patient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import sessions.ParameterFacadeLocal;
import sessions.PatientFacadeLocal;


/**
 *
 * @author nel
 */
public class parameterController implements Serializable {

    @EJB
    private ParameterFacadeLocal parameterFacade;
    private List<Parameter> listofParameters = new ArrayList<>();
    private Parameter parameter = new Parameter();
    
    
    @EJB
    private PatientFacadeLocal patientFacade;
    private List<Patient> listofPatients = new ArrayList<>();
    private Patient patient = new Patient();
    private String msg;
    private String operation;
    

    @PostConstruct
    public void init() {
        listofParameters.clear();
        listofParameters.addAll(parameterFacade.findAll());
        listofPatients.clear();
        listofPatients.addAll(patientFacade.findAll());
    }

    public void clear(ActionEvent e) {
        parameter = new Parameter();
        patient = new Patient();
        msg = "";
    }

    public void action() {
        msg = "";
        System.out.print("you and me ooouuuuuuuoo");
    }
  
    public void adds() {

        operation = "add";

        try {
          System.out.print("you and me");
          parameter.setIdpatient(patient);
          parameter.setIdparameter(parameterFacade.nextId());
          parameterFacade.create(parameter);
            msg = "Successful operation!";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
    }

    public void modifys() {

        try {
      
            parameterFacade.edit(parameter);
            msg = "Successful operation!";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('m_dialog').hide()");
        }
    }

    public void deletes() {

        operation = "delete";
        try {
            parameterFacade.remove(parameter);
            msg = "Successful operation!";
           
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
    }

    public ParameterFacadeLocal getParameterFacade() {
        return parameterFacade;
    }

    public void setParameterFacade(ParameterFacadeLocal parameterFacade) {
        this.parameterFacade = parameterFacade;
    }

    public List<Parameter> getListofParameters() {
        return listofParameters;
    }

    public void setListofParameters(List<Parameter> listofParameters) {
        this.listofParameters = listofParameters;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public PatientFacadeLocal getPatientFacade() {
        return patientFacade;
    }

    public void setPatientFacade(PatientFacadeLocal patientFacade) {
        this.patientFacade = patientFacade;
    }

    public List<Patient> getListofPatients() {
        return listofPatients;
    }

    public void setListofPatients(List<Patient> listofPatients) {
        this.listofPatients = listofPatients;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    
}
