
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entities.Branch;
import entities.Department;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import sessions.BranchFacadeLocal;
import sessions.DepartmentFacadeLocal;

/**
 *
 * @author nel
 */
public class departmentController implements Serializable {

    @EJB
    private BranchFacadeLocal branchFacade;
    private List<Branch> listofBranches = new ArrayList<>();
    private Branch branch = new Branch();
    
    @EJB
    private DepartmentFacadeLocal departmentFacade;
    private List<Department> listofDepartments = new ArrayList<>();
    private Department department = new Department();
    private String msg;
    private String operation;
    
    

    public departmentController() {
    }

    @PostConstruct
    public void init() {
         listofBranches.clear();
        listofBranches.addAll(branchFacade.findAll());
        listofDepartments.clear();
        listofDepartments.addAll(departmentFacade.findAll());
    }

    public void clear(ActionEvent e) {
         branch = new Branch();
        department = new Department();
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
            department.setIdbranch(branch);
            department.setIddepartment(departmentFacade.nextId());
            departmentFacade.create(department);
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
            departmentFacade.edit(department);
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
            departmentFacade.remove(department);
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

    public DepartmentFacadeLocal getDepartmentFacade() {
        return departmentFacade;
    }

    public void setDepartmentFacade(DepartmentFacadeLocal departmentFacade) {
        this.departmentFacade = departmentFacade;
    }

    public List<Department> getListofDepartments() {
        return listofDepartments;
    }

    public void setListofDepartments(List<Department> listofDepartments) {
        this.listofDepartments = listofDepartments;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
