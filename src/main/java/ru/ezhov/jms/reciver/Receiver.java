package ru.ezhov.jms.reciver;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.Message;
import javax.jms.JMSException;
import javax.jms.MessageListener;

import javax.ejb.MessageDriven;
import javax.ejb.ActivationConfigProperty;

@MessageDriven(name = "Receiver", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup",
                propertyValue = "java:/jms/queue/test"),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode",
                propertyValue = "Auto-acknowledge")})
public class Receiver implements MessageListener {
    private Logger LOG = Logger.getLogger(Receiver.class.getName());

    public static List<String> messages = new ArrayList();

    @Override
    public void onMessage(Message rcvMessage) {
        try {
            messages.add(rcvMessage.getBody(String.class));
        } catch (JMSException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
