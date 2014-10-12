/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import interceptors.Login;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Pawel
 */
@Named
@ViewScoped
public class LoggingBean {
    String name;
    @Inject UserBean user;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Login
    public String login(String username) {
        username = this.name;
        user.setUsername(username);
        System.out.println("Login, name : "+username);
        return "chat.xhtml?faces-redirect=true";
    }
    
}
