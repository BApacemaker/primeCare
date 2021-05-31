/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Branch;
import entities.Department;
import entities.Patient;
import entities.Transfer;
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
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;
import sessions.BranchFacadeLocal;
import sessions.DepartmentFacadeLocal;
import sessions.PatientFacadeLocal;
import sessions.TransferFacadeLocal;

/**
 *
 * @author nel
 */
public class transferController implements Serializable {

    @EJB
    private TransferFacadeLocal transferFacade;
     private List<Transfer> listofTransfers = new ArrayList<>();
    private Transfer transfer = new Transfer();
    
    
    @EJB
    private PatientFacadeLocal patientFacade;
    private List<Patient> listofPatient = new ArrayList<>();
    private Patient patient = new Patient();
    
    
    @EJB
    private BranchFacadeLocal branchFacade;
    private List<Branch> listofBranches = new ArrayList<>();
    private Branch branch = new Branch();
    private String msg;
    private String operation;

    public transferController() {
    }

    @PostConstruct
    public void init() {    
        listofPatient.clear();
        listofPatient.addAll(patientFacade.findAll());
        listofBranches.clear();
        listofBranches.addAll(branchFacade.findAll());
        listofTransfers.clear();
        listofTransfers.addAll(transferFacade.findAll());
    }

    public void clear(ActionEvent e) {
        patient = new Patient();
        transfer = new Transfer();
        branch = new Branch();
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
            transfer.setIdbranch(branch);
            transfer.setIdpatient(patient);
            transfer.setIdtransfer(transferFacade.nextId());
            transferFacade.create(transfer);
            msg = "Successful operation!";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('t_dialog').hide()");
        }
    }

    public void modifys() {

        try {
//            transfer.setIdbranch(branch);
//            transfer.setIdpatient(patient);
//        
            transferFacade.edit(transfer);
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
             transferFacade.remove(transfer);
            msg = "Successful operation!";
           
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
    }

    public TransferFacadeLocal getTransferFacade() {
        return transferFacade;
    }

    public void setTransferFacade(TransferFacadeLocal transferFacade) {
        this.transferFacade = transferFacade;
    }

    public List<Transfer> getListofTransfers() {
        return listofTransfers;
    }

    public void setListofTransfers(List<Transfer> listofTransfers) {
        this.listofTransfers = listofTransfers;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    public PatientFacadeLocal getPatientFacade() {
        return patientFacade;
    }

    public void setPatientFacade(PatientFacadeLocal patientFacade) {
        this.patientFacade = patientFacade;
    }

    public List<Patient> getListofPatient() {
        return listofPatient;
    }

    public void setListofPatient(List<Patient> listofPatient) {
        this.listofPatient = listofPatient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public BranchFacadeLocal getBranchFacade() {
        return branchFacade;
    }

    public void setBranchFacade(BranchFacadeLocal branchFacade) {
        this.branchFacade = branchFacade;
    }

    public List<Branch> getListofBranches() {
        return listofBranches;
    }

    public void setListofBranches(List<Branch> listofBranches) {
        this.listofBranches = listofBranches;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
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
