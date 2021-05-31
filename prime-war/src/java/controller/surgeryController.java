
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
import entities.Surgery;
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
import sessions.SurgeryFacadeLocal;


/**
 *
 * @author nel
 */
public class surgeryController implements Serializable {

    @EJB
    private SurgeryFacadeLocal surgeryFacade;
    private List<Surgery> listofSurgery = new ArrayList<>();
    private Surgery surgery = new Surgery();
    
    
    @EJB
    private PatientFacadeLocal patientFacade;
    private List<Patient> listofPatients = new ArrayList<>();
    private Patient patient = new Patient();
    private String msg;
    private String operation;
    

    @PostConstruct
    public void init() {
        listofSurgery.clear();
        listofSurgery.addAll(surgeryFacade.findAll());
        listofPatients.clear();
        listofPatients.addAll(patientFacade.findAll());
    }

    public void clear(ActionEvent e) {
        surgery = new Surgery();
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
          surgery.setIdpatient(patient);
          surgery.setIdsurgery(surgeryFacade.nextId());
          surgeryFacade.create(surgery);
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
             surgeryFacade.edit(surgery);
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
            surgeryFacade.remove(surgery);
            msg = "Successful operation!";
           
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
    }

    public SurgeryFacadeLocal getSurgeryFacade() {
        return surgeryFacade;
    }

    public void setSurgeryFacade(SurgeryFacadeLocal surgeryFacade) {
        this.surgeryFacade = surgeryFacade;
    }

    public List<Surgery> getListofSurgery() {
        return listofSurgery;
    }

    public void setListofSurgery(List<Surgery> listofSurgery) {
        this.listofSurgery = listofSurgery;
    }

    public Surgery getSurgery() {
        return surgery;
    }

    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
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
