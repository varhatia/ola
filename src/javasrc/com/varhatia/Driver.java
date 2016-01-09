package com.varhatia;

import com.varhatia.threads.Consumer;
import com.varhatia.threads.Producer;

/**
* Created by IntelliJ IDEA.
* User: varhatia
* Date: 9/1/16
* Time: 11:44 AM
* To change this template use File | Settings | File Templates.
*/
public class Driver {

    public static void main(String[] args)
    {
        //Create the controller
        Controller controller = new Controller();
        try
        {

            controller.start();

            Thread producer = new Thread(new Producer(controller.getContext().getDataQueue()));
            Thread consumer = new Thread(new Consumer(controller.getContext().getDataQueue()));

            producer.start();
            consumer.start();
//
//            //print queue
//            controller.getContext().getDataQueue().printQueue();
////
////            //pop nodes
//            controller.getContext().getDataQueue().pop();
////
////            //print queue
//            controller.getContext().getDataQueue().printQueue();
        }
        catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}

