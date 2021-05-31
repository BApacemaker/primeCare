/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Menu;
import entities.Usergroup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DualListModel;
import sessions.MenuFacadeLocal;
import sessions.UsergroupFacadeLocal;
import sessions.UserrFacadeLocal;

/**
 *
 * @author pas
 */ 
public class PrivilegesController implements Serializable , Converter{


    @EJB
    private UsergroupFacadeLocal userFacade;
    private List<Usergroup> listOfUsers = new ArrayList<>();
    private Usergroup user = new Usergroup();
    private Integer iduser;

    
    @EJB
    private MenuFacadeLocal menuFacade;
    private DualListModel<Menu> privileges = new DualListModel<>(new ArrayList<>(), new ArrayList<>());
    private String msg;
    
    
      public PrivilegesController(){}
    
    @PostConstruct
    
    public void init(){
      chargelistMenu();
      chargelistUser();
    
    }

    
    public void chargelistMenu(){
     
     privileges.getSource().clear();
     privileges.getSource().addAll(menuFacade.findAll());
     
     
     }
     public void chargelistUser(){
      
       listOfUsers.clear();
       listOfUsers.addAll(userFacade.findAll());
      
      }
      
      public void selectUser(){
       user = userFacade.find(iduser);
       chargelistMenu();
       privileges.getTarget().clear();
       privileges.getTarget().addAll((Collection)(user.getMenuList()));        
       privileges.getSource().removeAll(privileges.getTarget());
     
      }
      
      public void savePrivileges(){
      
      try{
       user.setMenuList(privileges.getTarget());
       userFacade.edit(user);
       msg = "successful operation";
       RequestContext.getCurrentInstance().execute("PF('e_dialog').hide()");
       
      } catch(Exception e){
       e.printStackTrace();
       msg = "successful operation.";
      
      }
      
      }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return menuFacade.find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
   
     return ((Menu) value).getIdmenu().toString();
    
    }
      
      
    
    public UsergroupFacadeLocal getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UsergroupFacadeLocal userFacade) {
        this.userFacade = userFacade;
    }

    public List<Usergroup> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(List<Usergroup> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public MenuFacadeLocal getMenuFacade() {
        return menuFacade;
    }

    public void setMenuFacade(MenuFacadeLocal menuFacade) {
        this.menuFacade = menuFacade;
    }

    public DualListModel<Menu> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(DualListModel<Menu> privileges) {
        this.privileges = privileges;
    }

    public String getMsg() {
        return msg;
    }

    public Usergroup getUser() {
        return user;
    }

    public void setUser(Usergroup user) {
        this.user = user;
    }

    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
      
      
      
      
}
