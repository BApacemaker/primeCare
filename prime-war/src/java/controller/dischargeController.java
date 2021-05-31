

package controller;

import entities.Admission;
import entities.Discharge;
import entities.Patient;
import java.io.Serializable;
import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import static net.sf.jasperreports.engine.JasperFillManager.fillReport;
import net.sf.jasperreports.engine.JasperPrint;
import org.primefaces.context.RequestContext;
import sessions.AdmissionFacadeLocal;
import sessions.DischargeFacadeLocal;
import sessions.PatientFacadeLocal;


/**
 *
 * @author nel
 */
public class dischargeController  implements Serializable {

    @EJB
    private PatientFacadeLocal patientFacade;
    private List<Patient> PatientList = new ArrayList<>();
    private Patient patient = new Patient();

    
    @EJB
    private DischargeFacadeLocal dischargeFacade;
    private List<Discharge> listofDischarge = new ArrayList<>();
    private Discharge discharge = new Discharge();


    @EJB
    private AdmissionFacadeLocal admissionFacade;
    private List<Admission> listOfAdmissions = new ArrayList<>();
    private Admission admission = new Admission();
    private String msg;
    private String operation;
    

    @PostConstruct
    public void init() {
        listOfAdmissions.clear();
        listOfAdmissions.addAll(admissionFacade.findAll());
        listofDischarge.clear();
        listofDischarge.addAll(dischargeFacade.findAll());
    }

    public void clear(ActionEvent e) {
        admission = new Admission();
        discharge = new Discharge();
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
            discharge.setIdadmission(admission);
           discharge.setIddischarge(dischargeFacade.nextId());
            dischargeFacade.create(discharge);
            msg = "Patient Successfully discharged!";
         
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
    }
    
        public String print (){
        try{
            forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prime", "postgres", "admin");
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/etat/h.jasper");
            JasperPrint jasperPrint = fillReport(reportPath, null, con);
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment;filename=List.pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            FacesContext.getCurrentInstance().responseComplete();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        ExternalContext ext = FacesContext.getCurrentInstance().getExternalContext();
        return ext.getRequestPathInfo()+"?faces-redirection=true";
    }
  

    public void modifys() {
        try {
        
                dischargeFacade.edit(discharge);
            msg = "discharge Successfully updated!";
        
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('m_dialog').hide()");
        }
    }

    public void deletes() {
        try {
                dischargeFacade.remove(discharge);
            msg = "Successful operation!";
           
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('d_dialog').hide()");
        }
    }

    public DischargeFacadeLocal getDischargeFacade() {
        return dischargeFacade;
    }

    public void setDischargeFacade(DischargeFacadeLocal dischargeFacade) {
        this.dischargeFacade = dischargeFacade;
    }

    public List<Discharge> getListofDischarge() {
        return listofDischarge;
    }

    public void setListofDischarge(List<Discharge> listofDischarge) {
        this.listofDischarge = listofDischarge;
    }

    public Discharge getDischarge() {
        return discharge;
    }

    public void setDischarge(Discharge discharge) {
        this.discharge = discharge;
    }

    public AdmissionFacadeLocal getAdmissionFacade() {
        return admissionFacade;
    }

    public void setAdmissionFacade(AdmissionFacadeLocal admissionFacade) {
        this.admissionFacade = admissionFacade;
    }

    public List<Admission> getListOfAdmissions() {
        return listOfAdmissions;
    }

    public void setListOfAdmissions(List<Admission> listOfAdmissions) {
        this.listOfAdmissions = listOfAdmissions;
    }

    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
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

    public PatientFacadeLocal getPatientFacade() {
        return patientFacade;
    }

    public void setPatientFacade(PatientFacadeLocal patientFacade) {
        this.patientFacade = patientFacade;
    }

    public List<Patient> getPatientList() {
        return PatientList;
    }

    public void setPatientList(List<Patient> PatientList) {
        this.PatientList = PatientList;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    
    
}
