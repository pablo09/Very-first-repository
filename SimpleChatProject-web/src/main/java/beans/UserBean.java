/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import ejb.Chatuser;
import ejb.ChatuserFacade;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Pawel
 */
@Stateful
@LocalBean
@SessionScoped
public class UserBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    ChatuserFacade facade;
    public UserBean() {
        System.out.println("USERBEAN CREATED, username = "+username);
    }
    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String name) {
        this.username = name;
        System.out.println("Username : "+name+" has been set");
    }
    @PreDestroy
    public void destroy() {
        Chatuser user = new Chatuser();
        user.setName(username);
        user.setStatus(false);
        facade.edit(user);
        System.out.println("DESTROYED for "+username);
    }
  
    
}
