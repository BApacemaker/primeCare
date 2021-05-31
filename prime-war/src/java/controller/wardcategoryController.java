/*
 * To change this license header, choose License Headers in Project Properties.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import entities.Wardcategory;
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
import sessions.WardcategoryFacadeLocal;

/**
 *
 * @author nel
 */
public class wardcategoryController implements Serializable {

    @EJB
    private WardcategoryFacadeLocal wardcategoryFacade;
    private List<Wardcategory> listofWardcategory = new ArrayList<>();
    private Wardcategory wardcategory = new Wardcategory();
    
    private String msg;
    private String operation;
    
    

    public wardcategoryController() {
    }

    @PostConstruct
    public void init() {
        listofWardcategory.clear();
        listofWardcategory.addAll(wardcategoryFacade.findAll());
       
    }

    public void clear(ActionEvent e) {
        wardcategory = new Wardcategory();
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
            
            wardcategory.setIdwardcategory(wardcategoryFacade.nextId());
            wardcategoryFacade.create(wardcategory);
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
            wardcategoryFacade.edit(wardcategory);
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
             wardcategoryFacade.remove(wardcategory);
            msg = "Successful operation!";
           
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Failure!";
        } finally {
            init();
            RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
        }
    }

    public WardcategoryFacadeLocal getWardcategoryFacade() {
        return wardcategoryFacade;
    }

    public void setWardcategoryFacade(WardcategoryFacadeLocal wardcategoryFacade) {
        this.wardcategoryFacade = wardcategoryFacade;
    }

    public List<Wardcategory> getListofWardcategory() {
        return listofWardcategory;
    }

    public void setListofWardcategory(List<Wardcategory> listofWardcategory) {
        this.listofWardcategory = listofWardcategory;
    }

    public Wardcategory getWardcategory() {
        return wardcategory;
    }

    public void setWardcategory(Wardcategory wardcategory) {
        this.wardcategory = wardcategory;
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
