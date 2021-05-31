
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entities.Department;
import entities.Userr;
import entities.Usergroup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import sessions.DepartmentFacadeLocal;
import sessions.UserrFacadeLocal;
import sessions.UsergroupFacadeLocal;

/**
 *
 * @author nel
 */
public class userController implements Serializable {

   
    @EJB
    private UserrFacadeLocal userFacade;
    private List<Userr> listOfUsers = new ArrayList<>();
    private Userr user = new Userr();

    
   @EJB
    private UsergroupFacadeLocal usergroupFacade;
    private List<Usergroup> listofUsergroups = new ArrayList<>();
    private Usergroup usergroup = new Usergroup();
    
    
    @EJB
    private DepartmentFacadeLocal departmentFacade;
    private List<Department> listofDepartments = new ArrayList<>();
    private Department department = new Department();
    private String msg;
    private String operation;
    
    

    public userController() {
    }

    @PostConstruct
    public void init() {
        listOfUsers.clear();
        listOfUsers.addAll(userFacade.findAll());
        listofUsergroups.clear();
        listofUsergroups.addAll(usergroupFacade.findAll());
        listofDepartments.clear();
        listofDepartments.addAll(departmentFacade.findAll());
    }

    public void clear(ActionEvent e) {
        user = new Userr();
        usergroup = new Usergroup();
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
            if(userFacade.findBypd(((Integer) user.getPwd().hashCode()).toString()) != null){
                 msg = "ERROR passward " + getUser().getPwd() + "Already registered";
            }else{
            System.out.print("you and me");
            user.setIddepartment(department);
            user.setIdusergroup(usergroup);
            user.setIduser(userFacade.nextId());
            user.setPwd(((Integer) user.getPwd().hashCode()).toString());
            userFacade.create(user);
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
//            transfer.setIdbranch(branch);
//            transfer.setIdpatient(patient);
            user.setPwd(((Integer) user.getPwd().hashCode()).toString());
            userFacade.edit(user);
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
            userFacade.remove(user);
            msg = "Successful operation!";
           
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
    }

    public UserrFacadeLocal getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UserrFacadeLocal userFacade) {
        this.userFacade = userFacade;
    }

    public List<Userr> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(List<Userr> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public Userr getUser() {
        return user;
    }

    public void setUser(Userr user) {
        this.user = user;
    }

    public UsergroupFacadeLocal getUsergroupFacade() {
        return usergroupFacade;
    }

    public void setUsergroupFacade(UsergroupFacadeLocal usergroupFacade) {
        this.usergroupFacade = usergroupFacade;
    }

    public List<Usergroup> getListofUsergroups() {
        return listofUsergroups;
    }

    public void setListofUsergroups(List<Usergroup> listofUsergroups) {
        this.listofUsergroups = listofUsergroups;
    }

    public Usergroup getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(Usergroup usergroup) {
        this.usergroup = usergroup;
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
