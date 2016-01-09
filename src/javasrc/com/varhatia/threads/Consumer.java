package com.varhatia.threads;

import com.varhatia.Model.Node;
import com.varhatia.data.DataQueue;

/**
 * Created by IntelliJ IDEA.
 * User: varhatia
 * Date: 9/1/16
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Consumer implements Runnable {

    DataQueue queue;

    public Consumer(DataQueue dataQueue) {
        queue = dataQueue;

    }

    public void run() {
        while(true)
        {
            Node node = queue.take();
            if(node!=null)
                System.out.print("Consuming"+node.getValue());
        }
    }
}
