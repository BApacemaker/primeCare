/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Menu;
import entities.Operations;
import entities.Userr;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import sessions.OperationsFacadeLocal;
import sessions.UserrFacadeLocal;

/**
 *
 * @author pas
 */
public class SessionController implements Serializable {

    @EJB
    private OperationsFacadeLocal operationsFacade;

    @EJB
    private UserrFacadeLocal userFacade;
    private String language = "en";
    private Userr currentUser = new Userr();
    private String msg;
    
    
    private Boolean dashboard = false;
    private Boolean profile = false;
    private Boolean hospitalization = false;
    private Boolean allocate_ward = false;
    private Boolean outpatient = false;
    private Boolean reception = false;
    private Boolean activity = false;
    private Boolean progress = false;
    private Boolean operatons = false;
    private Boolean department = false;
    private Boolean branch = false;
    private Boolean usergroup = false;
    private Boolean user = false;
    private Boolean medical = false;
    private Boolean privilege = false;
    private Boolean admission = false;
    private Boolean discharge = false;
    private Boolean treatement = false;
    private Boolean transfer = false;
    private Boolean bed = false;
    private Boolean ward = false;
    private Boolean wardcat = false;
    private Boolean parameter = false;
    private Boolean consultation = false;
    private Boolean patient = false;
    private Boolean appointment = false;
    private Boolean medicalservice = false;
    private Boolean medicaltest = false;
    private Boolean surgery = false;

    /**
     * Creates a new instance of SessionController
     */
    public SessionController() {
    }

    public String english() {
        language = "en";
        return FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo() + "?faces-redirect=true";
    }

    public String french() {
        language = "fr";
        return FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo() + "?faces-redirect=true";
    }

    public void watchOut() {
        try {
            if (!FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("currentUser")) {
                ((FacesContext.getCurrentInstance()).getExternalContext()).redirect("index.xhtml?faces-redirect=true");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logFile(String name, String target) {
        try {

            Operations op = new Operations();
            op.setIdoperation(operationsFacade.nextId());
            op.setDate(new Date(System.currentTimeMillis()));
            op.setIpaddress(((ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr());
            op.setName(name);
            op.setTarget(target);
            op.setTime(new Time(System.currentTimeMillis()));
            op.setIduser((Userr) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("currentUser"));
            operationsFacade.create(op);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String authenticate() {
        try {

            currentUser = userFacade.findByLoginPwd(currentUser.getLogin(), ((Integer) currentUser.getPwd().hashCode()).toString());

            if (currentUser != null) {
                msg ="";
                logFile("Log in", "System");
                System.out.println("Menu : " + currentUser.getIdusergroup().getMenuList().size());
                for (Menu m : currentUser.getIdusergroup().getMenuList()) {
                    dashboard = dashboard ? true : m.getCode().equals("dashboard");
                    profile = profile ? true : m.getCode().equals("profile");
                    hospitalization = hospitalization ? true : m.getCode().equals("hospitalization");
                    allocate_ward = allocate_ward ? true : m.getCode().equals("allocate_ward");
                    outpatient = outpatient ? true : m.getCode().equals("outpatient");
                    reception = reception ? true : m.getCode().equals("reception");
                    operatons = operatons ? true : m.getCode().equals("operatons");
                    activity = activity ? true : m.getCode().equals("activity");
                    progress = progress ? true : m.getCode().equals("progress");
                    department = department ? true : m.getCode().equals("department");
                    branch = branch ? true : m.getCode().equals("branch");
                    usergroup = usergroup ? true : m.getCode().equals("usergroup");
                    user = user ? true : m.getCode().equals("user");
                    privilege = privilege ? true : m.getCode().equals("privilege");
                    admission = admission ? true : m.getCode().equals("admission");
                    discharge = discharge ? true : m.getCode().equals("discharge");
                    treatement = treatement ? true : m.getCode().equals("treatement");
                    transfer = transfer ? true : m.getCode().equals("transfer");
                    bed = bed ? true : m.getCode().equals("bed");
                    ward = ward ? true : m.getCode().equals("ward");
                    wardcat = wardcat ? true : m.getCode().equals("wardcat");
                    medical = medical ? true : m.getCode().equals("medical");
                    patient = patient ? true : m.getCode().equals("patient");
                    parameter = parameter ? true : m.getCode().equals("parameter");
                    consultation = consultation ? true : m.getCode().equals("consultation");
                    appointment = appointment ? true : m.getCode().equals("appointment");
                    medicalservice = medicalservice ? true : m.getCode().equals("medicalservice");
                    medicaltest = medicaltest ? true : m.getCode().equals("medicaltest");
                    surgery = surgery ? true : m.getCode().equals("surgery");
                }
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentUser", currentUser);
               
                return "home.xhtml?faces-redirect=true";
            } else {
              msg = "Account not found , Error in username or password";
          
                currentUser = new Userr();
                return "index.xhtml?faces-redirect=true";
            }
        } catch (Exception e) {
            e.printStackTrace(); 
             msg = "Account not found , Error in username or password";
            currentUser = new Userr();
            return "index.xhtml?faces-redirect=true";
        }
    }

    public String logOut() { 
        try {
            msg ="";
            logFile("Log out", "System");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("currentUser");
            ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return "index.xhtml?faces-redirect=true";
        }
    }

    public OperationsFacadeLocal getOperationsFacade() {
        return operationsFacade;
    }

    public void setOperationsFacade(OperationsFacadeLocal operationsFacade) {
        this.operationsFacade = operationsFacade;
    }

    public UserrFacadeLocal getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UserrFacadeLocal userFacade) {
        this.userFacade = userFacade;
    }

    public Userr getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Userr currentUser) {
        this.currentUser = currentUser;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getOperatons() {
        return operatons;
    }

    public void setOperatons(Boolean operatons) {
        this.operatons = operatons;
    }

    public Boolean getMedical() {
        return medical;
    }

    public void setMedical(Boolean medical) {
        this.medical = medical;
    }

  
    public Boolean getWardcat() {
        return wardcat;
    }

    public void setWardcat(Boolean wardcat) {
        this.wardcat = wardcat;
    }

    public Boolean getProfile() {
        return profile;
    }

    public Boolean getWardcategory() {
        return wardcat;
    }

    public void setWardcategory(Boolean wardcat) {
        this.wardcat = wardcat;
    }

    public void setProfile(Boolean profile) {
        this.profile = profile;
    }

    public Boolean getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(Boolean hospitalization) {
        this.hospitalization = hospitalization;
    }

    public Boolean getAllocate_ward() {
        return allocate_ward;
    }

    public void setAllocate_ward(Boolean allocate_ward) {
        this.allocate_ward = allocate_ward;
    }

    public Boolean getOutpatient() {
        return outpatient;
    }

    public void setOutpatient(Boolean outpatient) {
        this.outpatient = outpatient;
    }

    public Boolean getReception() {
        return reception;
    }

    public void setReception(Boolean reception) {
        this.reception = reception;
    }

    public Boolean getActivity() {
        return activity;
    }

    public void setActivity(Boolean activity) {
        this.activity = activity;
    }

    public Boolean getProgress() {
        return progress;
    }

    public void setProgress(Boolean progress) {
        this.progress = progress;
    }

    public Boolean getDepartment() {
        return department;
    }

    public void setDepartment(Boolean department) {
        this.department = department;
    }

    public Boolean getBranch() {
        return branch;
    }

    public void setBranch(Boolean branch) {
        this.branch = branch;
    }

    public Boolean getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(Boolean usergroup) {
        this.usergroup = usergroup;
    }

    public Boolean getUser() {
        return user;
    }

    public void setUser(Boolean user) {
        this.user = user;
    }

    public Boolean getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Boolean privilege) {
        this.privilege = privilege;
    }

    public Boolean getAdmission() {
        return admission;
    }

    public void setAdmission(Boolean admission) {
        this.admission = admission;
    }

    public Boolean getDischarge() {
        return discharge;
    }

    public void setDischarge(Boolean discharge) {
        this.discharge = discharge;
    }

    public Boolean getTreatement() {
        return treatement;
    }

    public void setTreatement(Boolean treatement) {
        this.treatement = treatement;
    }

    public Boolean getTransfer() {
        return transfer;
    }

    public void setTransfer(Boolean transfer) {
        this.transfer = transfer;
    }

    public Boolean getBed() {
        return bed;
    }

    public void setBed(Boolean bed) {
        this.bed = bed;
    }

    public Boolean getWard() {
        return ward;
    }

    public void setWard(Boolean ward) {
        this.ward = ward;
    }

    public Boolean getParameter() {
        return parameter;
    }

    public void setParameter(Boolean parameter) {
        this.parameter = parameter;
    }

    public Boolean getConsultation() {
        return consultation;
    }

    public void setConsultation(Boolean consultation) {
        this.consultation = consultation;
    }

    public Boolean getPatient() {
        return patient;
    }

    public void setPatient(Boolean patient) {
        this.patient = patient;
    }

    public Boolean getAppointment() {
        return appointment;
    }

    public void setAppointment(Boolean appointment) {
        this.appointment = appointment;
    }

    public Boolean getMedicalservice() {
        return medicalservice;
    }

    public void setMedicalservice(Boolean medicalservice) {
        this.medicalservice = medicalservice;
    }

    public Boolean getMedicaltest() {
        return medicaltest;
    }

    public void setMedicaltest(Boolean medicaltest) {
        this.medicaltest = medicaltest;
    }

    public Boolean getSurgery() {
        return surgery;
    }

    public void setSurgery(Boolean surgery) {
        this.surgery = surgery;
    }

    public Boolean getDashboard() {
        return dashboard;
    }

    public void setDashboard(Boolean dashboard) {
        this.dashboard = dashboard;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    
}
