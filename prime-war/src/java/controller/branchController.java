

package controller;

import entities.Branch;
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
import sessions.PatientFacadeLocal;
import sessions.TransferFacadeLocal;

/**
 *
 * @author nel
 */
public class branchController implements Serializable {

    @EJB
    private BranchFacadeLocal branchFacade;
    private List<Branch> listofBranches = new ArrayList<>();
    private Branch branch = new Branch();
    private String msg;
    private String operation;

    public branchController() {
    }

    @PostConstruct
    public void init() {
        
        listofBranches.clear();
        listofBranches.addAll(branchFacade.findAll());
       
    }

    public void clear(ActionEvent e) {
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
            branch.setIdbranch(branchFacade.nextId());
            branchFacade.create(branch);
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
            branchFacade.edit(branch);
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
            branchFacade.remove(branch);
            msg = "Successful operation!";
           
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
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
