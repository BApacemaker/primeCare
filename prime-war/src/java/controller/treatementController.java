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

import entities.Admission;
import entities.Medicalservice;
import entities.Treatment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import sessions.AdmissionFacadeLocal;
import sessions.MedicalserviceFacadeLocal;
import sessions.TreatmentFacadeLocal;

/**
 *
 * @author nel
 */
public class treatementController implements Serializable {

    @EJB
    private TreatmentFacadeLocal treatmentFacade;
    private List<Treatment> listofTreatments = new ArrayList<>();
    private Treatment treatment = new Treatment();

    @EJB
    private AdmissionFacadeLocal admissionFacade;
    private List<Admission> listofAdmissions = new ArrayList<>();
    private Admission admission = new Admission();

    @EJB
    private MedicalserviceFacadeLocal medicalserviceFacade;
    private List<Medicalservice> listofMedicalservices = new ArrayList<>();
    private Medicalservice medicalservice = new Medicalservice();

    private String msg;
    private String operation;

    @PostConstruct
    public void init() {
        listofTreatments.clear();
        listofTreatments.addAll(treatmentFacade.findAll());
        listofAdmissions.clear();
        listofAdmissions.addAll(admissionFacade.findAll());
        listofMedicalservices.clear();
        listofMedicalservices.addAll(medicalserviceFacade.findAll());
    }

    public void clear(ActionEvent e) {
        treatment = new Treatment();
        admission = new Admission();
        medicalservice = new Medicalservice();
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
              if(treatmentFacade.findbytreate(treatment.getDetail(),treatment.getDate(),treatment.getTime()) != null){
                 msg = "ERROR " + treatment + " Already registered";
            } else {
   
            System.out.print("you and me");
            treatment.setIdadmission(admission);
            treatment.setIdmedicalservice(medicalservice);
            treatment.setIdtreatment(treatmentFacade.nextId());
            treatmentFacade.create(treatment);
            msg = "Successful operation!";
           }
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
            if(treatmentFacade.findbytreate(treatment.getDetail(),treatment.getDate(),treatment.getTime()) != null){
                 msg = "ERROR " + treatment + " Already registered";
            } else {
            treatmentFacade.edit(treatment);
            msg = "Successful operation!";
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
            treatmentFacade.remove(treatment);
            msg = "Successful operation!";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
    }

    public TreatmentFacadeLocal getTreatmentFacade() {
        return treatmentFacade;
    }

    public void setTreatmentFacade(TreatmentFacadeLocal treatmentFacade) {
        this.treatmentFacade = treatmentFacade;
    }

    public List<Treatment> getListofTreatments() {
        return listofTreatments;
    }

    public void setListofTreatments(List<Treatment> listofTreatments) {
        this.listofTreatments = listofTreatments;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public AdmissionFacadeLocal getAdmissionFacade() {
        return admissionFacade;
    }

    public void setAdmissionFacade(AdmissionFacadeLocal admissionFacade) {
        this.admissionFacade = admissionFacade;
    }

    public List<Admission> getListofAdmissions() {
        return listofAdmissions;
    }

    public void setListofAdmissions(List<Admission> listofAdmissions) {
        this.listofAdmissions = listofAdmissions;
    }

    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    public MedicalserviceFacadeLocal getMedicalserviceFacade() {
        return medicalserviceFacade;
    }

    public void setMedicalserviceFacade(MedicalserviceFacadeLocal medicalserviceFacade) {
        this.medicalserviceFacade = medicalserviceFacade;
    }

    public List<Medicalservice> getListofMedicalservices() {
        return listofMedicalservices;
    }

    public void setListofMedicalservices(List<Medicalservice> listofMedicalservices) {
        this.listofMedicalservices = listofMedicalservices;
    }

    public Medicalservice getMedicalservice() {
        return medicalservice;
    }

    public void setMedicalservice(Medicalservice medicalservice) {
        this.medicalservice = medicalservice;
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
