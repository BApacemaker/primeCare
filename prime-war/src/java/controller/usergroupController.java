
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
public class usergroupController implements Serializable {

   @EJB
    private UsergroupFacadeLocal usergroupFacade;
    private List<Usergroup> listofUsergroups = new ArrayList<>();
    Usergroup usergroup = new Usergroup();
    private String msg;
    private String operation;
    
    

    public usergroupController() {
    }

    @PostConstruct
    public void init() {
        listofUsergroups.clear();
        listofUsergroups.addAll(usergroupFacade.findAll());

    }

    public void clear(ActionEvent e) {
        usergroup = new Usergroup();
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
        
            usergroup.setIdusergroup(usergroupFacade.nextId());          
            usergroupFacade.create(usergroup);
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
            usergroupFacade.edit(usergroup);
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
            usergroupFacade.remove(usergroup);
            msg = "Successful operation!";
           
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
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
