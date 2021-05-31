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

import entities.Medicalservice;
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
import sessions.MedicalserviceFacadeLocal;

/**
 *
 * @author nel
 */
public class medicalserviceController implements Serializable {

    @EJB
    private MedicalserviceFacadeLocal medicalserviceFacade;
    private List<Medicalservice> listofMedicalservices = new ArrayList<>();
    private Medicalservice medicalservice = new Medicalservice();

    private String msg;
    private String operation;

    @PostConstruct
    public void init() {
        listofMedicalservices.clear();
        listofMedicalservices.addAll(medicalserviceFacade.findAll());
    }

    public void clear(ActionEvent e) {
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
            System.out.print("you and me");
            medicalservice.setIdmedicalservice(medicalserviceFacade.nextId());
            medicalserviceFacade.create(medicalservice);
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
            medicalserviceFacade.edit(medicalservice);
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
            medicalserviceFacade.remove(medicalservice);
            msg = "Successful operation!";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
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
