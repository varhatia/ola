package com.varhatia;

import com.varhatia.data.DataQueue;
import com.varhatia.data.DataQueueImpl;

/**
 * Created by IntelliJ IDEA.
 * User: varhatia
 * Date: 9/1/16
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class Controller {




    private ControllerContext context = null;
    public void start() throws Exception
    {
        try
        {
            System.out.println("STARTING CONTROLLER SERVICES...");
            context = new ControllerContext();
            System.out.println("READING CONTROLLER PROPERTIES...");
            ControllerProperties properties = new ControllerProperties();
            context.setProperties(properties);

            //Create task queue
            System.out.println("CREATING QUEUE...");
            DataQueue dataQueue = new DataQueueImpl();
            dataQueue.init(context);
            context.setDataQueue(dataQueue);
            System.out.println("CONTROLLER STARTED SUCCESFULLY...");
        }
        catch(Exception e)
        {
            System.out.println("Exception while starting.. Stopping services that were successfully started");
            stop();
            throw  e;
        }
    }

    protected void stop() {
        //To change body of created methods use File | Settings | File Templates.
    }
    public ControllerContext getContext() {
         return context;
     }

}
