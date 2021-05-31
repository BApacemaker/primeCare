
package controller;

import entities.Admission;
import entities.Patient;
import java.io.Serializable;
import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;
import sessions.AdmissionFacadeLocal;
import sessions.PatientFacadeLocal;


public class patientController implements Serializable {

    @EJB
    private PatientFacadeLocal patientFacade;
    private List<Patient> listOfPatient = new ArrayList<>();
    private Patient patient = new Patient();
    private String msg;
    private String operation;

    
     @EJB
    private AdmissionFacadeLocal admissionFacade;
    private List<Admission> listOfAdurations = new ArrayList<>();
    private Admission admission = new Admission();
 
    @PostConstruct
    public void init() {
        listOfPatient.clear();
        listOfPatient.addAll(patientFacade.findAll());
        listOfAdurations.clear();
        listOfAdurations.addAll(patientFacade.admdate());
    }

    public void prepareCreate(ActionEvent e) {
        patient = new Patient();
        msg = "";
        action(e);
       
    }

    public void saveAccount() {
        
        Random rnd = new Random();
       String mat = "PC_" + rnd.nextInt();
        try {
            
            if(patientFacade.findbycheck(patient.getPhone(),patient.getEmail(),patient.getGuidemail(),patient.getGuidenumber()) != null){
                 msg = "ERROR: Patient Already registered";
            } else {
   
           patient.setMatricule(mat);
            patient.setIdpatient(patientFacade.nextId());          
            patientFacade.create(patient);
            msg = "Patient Registered Successfully!";
            } 
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
    }

       
    public void modifyAccount() {
        try {
              if(patientFacade.findbycheck(patient.getPhone(),patient.getEmail(),patient.getGuidemail(),patient.getGuidenumber()) != null){
                 msg = "ERROR: Patient Already registered";
            } else {
   
            patientFacade.edit(patient);
            msg = "Patient information Successfully updated!";
              }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
    }

    public void deleteAccount() {
        try {
            patientFacade.remove(patient);
            msg = "Successful operation!";
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
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/etat/patient.jasper");
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
    
    
    public void action(ActionEvent e) {
        CommandButton btn = (CommandButton) e.getComponent();
        operation = btn.getWidgetVar();
        msg = "";
        System.out.print("you and me uuuuuuuuuu");
    }

    public void persist(){ 
        System.out.print("you and me ooouuuuuuuoo");
        switch (operation) {
        
            case "add":
                saveAccount();
                break;
            case "modify":
                modifyAccount();
                break;
            case "delete":
                deleteAccount();
                break;
        }
    }


    public PatientFacadeLocal getPatientFacade() {
        return patientFacade;
    }

    public void setPatientFacade(PatientFacadeLocal patientFacade) {
        this.patientFacade = patientFacade;
    }

    public List<Patient> getListOfPatient() {
        return listOfPatient;
    }

    public void setListOfPatient(List<Patient> listOfPatient) {
        this.listOfPatient = listOfPatient;
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

    public AdmissionFacadeLocal getAdmissionFacade() {
        return admissionFacade;
    }

    public void setAdmissionFacade(AdmissionFacadeLocal admissionFacade) {
        this.admissionFacade = admissionFacade;
    }

    public List<Admission> getListOfAdurations() {
        return listOfAdurations;
    }

    public void setListOfAdurations(List<Admission> listOfAdurations) {
        this.listOfAdurations = listOfAdurations;
    }

    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }


}
