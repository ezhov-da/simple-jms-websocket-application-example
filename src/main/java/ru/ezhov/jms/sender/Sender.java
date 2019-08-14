package ru.ezhov.jms.sender;

import javax.annotation.Resource;

import javax.inject.Inject;

import javax.jms.Queue;
import javax.jms.JMSContext;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Sender
{
    @Resource(mappedName = "java:/jms/queue/test")
    private Queue queue;

    @Inject
    private JMSContext context;

    public void sendMessage(String txt) {
        context.createProducer().send(queue, txt);
    }
}