/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.Chatuser;
import ejb.ChatuserFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author Pawel
 */
@Named
@ApplicationScoped
public class ChatBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    ChatuserFacade facade;
    @Inject
    UserBean user;
    private List<Chatuser> users;
    private String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String msg) {
        this.message = msg;
    }
    public UserBean getUser() {
        return user;
    }
    public void setUserBean(UserBean user) {
        this.user = user;
    }
    public List<Chatuser> getUsers() {
        System.out.println("GET USERS");
        users = facade.findAllOnline();
        return users;
    }
    public void setUsers(List<Chatuser> users) {
        this.users = users;
    }
    @PostConstruct
    public void init() {
       
    }
    public String destroy () {
        
        FacesContext facesContext = FacesContext.getCurrentInstance();  
        ExternalContext ex = facesContext .getExternalContext();  
        ex.invalidateSession(); 
        return "index.xhtml?faces-redirect=true";
    }
   

    
}
