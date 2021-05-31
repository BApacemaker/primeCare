
package controller;

import entities.Branch;
import entities.Ward;
import entities.Wardcategory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;
import sessions.BranchFacadeLocal;
import sessions.WardFacadeLocal;
import sessions.WardcategoryFacadeLocal;

/**
 *
 * @author nel
 */
public class wardController implements Serializable {

    @EJB
    private WardcategoryFacadeLocal wardcategoryFacade;
    private List<Wardcategory> listofWardcategory = new ArrayList<>();
    private Wardcategory wardcategory = new Wardcategory();
    
    @EJB
    private WardFacadeLocal wardFacade;
    private List<Ward> listofWards = new ArrayList<>();
    private Ward ward = new Ward();

    @EJB
    private BranchFacadeLocal branchFacade;
    private List<Branch> listofBranches = new ArrayList<>();
    private Branch branch = new Branch();
    
    private String msg;
    private String operation;
    
    

    public wardController() {
    }

    @PostConstruct
    public void init() {
        listofWardcategory.clear();
        listofWardcategory.addAll(wardcategoryFacade.findAll());
        listofWards.clear();
        listofWards.addAll(wardFacade.findAll());
        listofBranches.clear();
        listofBranches.addAll(branchFacade.findAll());
    }

    public void clear(ActionEvent e) {
        wardcategory = new Wardcategory();
        ward = new Ward();
        branch = new Branch();
        msg = "";

    }

    public void action() {
        msg = "";
        System.out.print("you and me ooouuuuuuuoo");
    }

 
    public void adds() {

        operation = "add";

        Random rnd = new Random();
       String mat = "W." + rnd.nextInt();
        
        
        try {
        
            ward.setIdwardcategory(wardcategory);
            ward.setCode(mat);
            ward.setState("ALMOST EMPTY");
            ward.setIdbranch(branch);
            ward.setIdward(wardFacade.nextId());
            wardFacade.create(ward);
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
           wardFacade.edit(ward);
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
            wardFacade.remove(ward);
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
