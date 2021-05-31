
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entities.Bed;
import entities.Ward;
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
import sessions.BedFacadeLocal;
import sessions.WardFacadeLocal;

/**
 *
 * @author nel
 */
public class bedController implements Serializable {

    @EJB
    private WardFacadeLocal wardFacade;
    private List<Ward> listofWards = new ArrayList<>();
    private Ward ward = new Ward();

    @EJB
    private BedFacadeLocal bedFacade;
    private List<Bed> listofBeds = new ArrayList<>();
    private Bed bed = new Bed();
    
    private String msg;
    private String operation;
    
    

    public bedController() {
    }

    @PostConstruct
    public void init() {
        listofBeds.clear();
        listofBeds.addAll(bedFacade.findAll());
        listofWards.clear();
        listofWards.addAll(wardFacade.findAll());
    }

    public void clear(ActionEvent e) {
        bed = new Bed();
        ward = new Ward();
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
            bed.setIdward(ward);
           bed.setIdbed(bedFacade.nextId());
            bedFacade.create(bed);
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
           bedFacade.edit(bed);
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
            bedFacade.remove(bed);
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

    public BedFacadeLocal getBedFacade() {
        return bedFacade;
    }

    public void setBedFacade(BedFacadeLocal bedFacade) {
        this.bedFacade = bedFacade;
    }

    public List<Bed> getListofBeds() {
        return listofBeds;
    }

    public void setListofBeds(List<Bed> listofBeds) {
        this.listofBeds = listofBeds;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
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
