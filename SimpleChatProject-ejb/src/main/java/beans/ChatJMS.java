/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Pawel
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/ChatTopic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "durable"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/ChatTopic"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/ChatTopic")
})
public class ChatJMS implements MessageListener {
    
    public ChatJMS() {
    }
    
    @Override
    public void onMessage(Message message) {
        ObjectMessage msg = null;
            if(message instanceof ObjectMessage) {
                msg = (ObjectMessage) message;
            }
        
    }
    
}
