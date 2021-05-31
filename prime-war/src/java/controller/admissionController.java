/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Admission;
import entities.Patient;
import entities.Ward;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import sessions.AdmissionFacadeLocal;
import sessions.PatientFacadeLocal;
import sessions.WardFacadeLocal;
import sessions.DischargeFacadeLocal;

/**
 *
 * @author nel
 */
public class admissionController implements Serializable {

    @EJB
    private DischargeFacadeLocal dischargeFacade;

    @EJB
    private WardFacadeLocal wardFacade;
    private List<Ward> listofWards = new ArrayList<>();
    private Ward ward = new Ward();

    @EJB
    private PatientFacadeLocal patientFacade;
    private List<Patient> listofPatients = new ArrayList<>();
    private Patient patient = new Patient();

    @EJB
    private AdmissionFacadeLocal admissionFacade;
    private List<Admission> listOfAdmissions = new ArrayList<>();

    private List<Admission> listOfAdurations = new ArrayList<>();
    private Admission admission = new Admission();
    private String msg;
    private String operation;
    public admissionController() {
    }

    @PostConstruct
    public void init() {
        listOfAdmissions.clear();
        listOfAdmissions.addAll(admissionFacade.findAll());
        listofWards.clear();
        listofWards.addAll(wardFacade.findAll());
        listofPatients.clear();
        listofPatients.addAll(patientFacade.findAll());
    }

    public void clear(ActionEvent e) {
        admission = new Admission();
        ward = new Ward();
        patient = new Patient();
        msg = "";

    }

    public List<Admission> getListOfAdurations() {
        return listOfAdurations;
    }

    public void setListOfAdurations(List<Admission> listOfAdurations) {
        
        this.listOfAdurations = listOfAdurations;
    }
    
 
    
    public DischargeFacadeLocal getDischargeFacade() {
        return dischargeFacade;
    }

    public void setDischargeFacade(DischargeFacadeLocal dischargeFacade) {
        this.dischargeFacade = dischargeFacade;
    }

    public void action() {

        msg = "";

    }
 
    public void adds() {

        operation = "add";

        try {
            if(admissionFacade.findbyadm(admission.getPurpose(),admission.getDate(),admission.getTime()) != null){
                 msg = "ERROR: " + admission  + " Already registered";
            } else {
                if((admission.getDate()).after(admission.getDateLine())){
                 msg = ""; 
                 msg = "ERROR: The Dateline Must be greater than the Admission date";
               } else {
                 System.out.print("you and me");
                 admission.setIdward(ward);
                 admission.setIdpatient(patient);
                 admission.setIdadmission(admissionFacade.nextId());
                 admissionFacade.create(admission);
                 msg = "Success -: patient is Admitted";
                 }
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
    }

    public void con() {
        operation = "o";

        try {       

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('con_dialog').hide()");
        }
    }

    public void modifys() {

        try {
            if(admissionFacade.findbyadm(admission.getPurpose(),admission.getDate(),admission.getTime()) != null){
                 msg = "ERROR:" + admission  + " Already registered";
            } else {
                if((admission.getDate()).after(admission.getDateLine())){
                 msg = "ERROR: The Dateline Must be greater than the Admission date";
               } else {
            admissionFacade.edit(admission);
            msg = "admission Successfully updated !";
            }
          }
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
            admissionFacade.remove(admission);
            msg = "Successful operation!";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
    }
    
    public WardFacadeLocal getWardFacade() {
        return wardFacade;
    }

    public void setWardFacade(WardFacadeLocal wardFacade) {
        this.wardFacade = wardFacade;
    }

    public List<Ward> getListofWards() {
        return listofWards;
    }

    public void setListofWards(List<Ward> listofWards) {
        this.listofWards = listofWards;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
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

}
