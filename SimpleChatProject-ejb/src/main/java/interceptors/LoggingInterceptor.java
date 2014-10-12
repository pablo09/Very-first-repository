/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import ejb.Chatuser;
import ejb.ChatuserFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Pawel
 */

@Login
@Interceptor
public class LoggingInterceptor {
    @EJB
    ChatuserFacade facade;
    @AroundInvoke
    public Object login(InvocationContext context) throws Exception {
        System.out.println(context.getMethod().getName());
        if(context.getMethod().getName().equals("setName")) {
            Object[] obj = context.getParameters();
            System.out.println("OBJ[0] : "+obj[0]);
           // context.setParameters(obj);
            
            System.out.println(context.getParameters()[0]);
            return context.proceed();
        }
        else {
            Object result = context.proceed();
            Object[] obj = context.getParameters();
            System.out.println("text : "+obj.length);
            System.out.println("."+obj[0]+".");
            String name = null;
            for(Object o : obj) {
                name = o.toString();
                System.out.println(o.toString());
            }
            System.out.println("name : "+name);
            List l = facade.getUser(name);
            if(l.isEmpty()) {
                Chatuser chatUser = new Chatuser();
                chatUser.setName(name);
                chatUser.setStatus(true);
                facade.create(chatUser);
                return context.proceed();
            }
            else {
                FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username already exists",
                            "Username already exists"));
                return "";
            }
            
        }  
       
    }
}
