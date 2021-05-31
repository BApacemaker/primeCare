
/**
 *
 * @author pas
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import entities.Medicaltest;
import entities.Patient;
import java.io.Serializable;
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
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;
import sessions.MedicaltestFacadeLocal;
import sessions.ParameterFacadeLocal;
import sessions.PatientFacadeLocal;


/**
 *
 * @author nel
 */
public class medicalTestController implements Serializable {

    @EJB
    private MedicaltestFacadeLocal medicaltestFacade;
    private List<Medicaltest> listofMedicaltests = new ArrayList<>();
    private Medicaltest medicaltest = new Medicaltest();
    
    
    @EJB
    private PatientFacadeLocal patientFacade;
    private List<Patient> listofPatients = new ArrayList<>();
    private Patient patient = new Patient();
    private String msg;
    private String operation;
    

    @PostConstruct
    public void init() {
        listofMedicaltests.clear();
        listofMedicaltests.addAll(medicaltestFacade.findAll());
        listofPatients.clear();
        listofPatients.addAll(patientFacade.findAll());
    }

    public void clear(ActionEvent e) {
        medicaltest = new Medicaltest();
        patient = new Patient();
        msg = "";
//        action(e);
    }

    public void action() {
//
//        CommandButton btn = (CommandButton) e.getComponent();
//        operation = btn.getWidgetVar();
        msg = "";
        System.out.print("you and me ooouuuuuuuoo");
    }

//         public void swap() {
//        
//
//        switch(operation){
//
//            case "add":
//                adds();
//                break;
//
//            case "modify":
//                modifys();
//                break;
//
//            case "delete":
//                deletes();
//                break;
//
//        }
//    }  
    public void adds() {

        operation = "add";

        try {
          System.out.print("you and me");
          medicaltest.setIdpatient(patient);
          medicaltest.setIdmedicaltest(medicaltestFacade.nextId());
          medicaltestFacade.create(medicaltest);
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
//            transfer.setIdbranch(branch);
//            transfer.setIdpatient(patient);
//        
             medicaltestFacade.edit(medicaltest);
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
             medicaltestFacade.remove(medicaltest);
            msg = "Successful operation!";
           
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
    }

    public MedicaltestFacadeLocal getMedicaltestFacade() {
        return medicaltestFacade;
    }

    public void setMedicaltestFacade(MedicaltestFacadeLocal medicaltestFacade) {
        this.medicaltestFacade = medicaltestFacade;
    }

    public List<Medicaltest> getListofMedicaltests() {
        return listofMedicaltests;
    }

    public void setListofMedicaltests(List<Medicaltest> listofMedicaltests) {
        this.listofMedicaltests = listofMedicaltests;
    }

    public Medicaltest getMedicaltest() {
        return medicaltest;
    }

    public void setMedicaltest(Medicaltest medicaltest) {
        this.medicaltest = medicaltest;
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
