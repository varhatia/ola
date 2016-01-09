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
public class Producer implements Runnable {

    DataQueue queue;

    public Producer(DataQueue dataQueue) {
        queue = dataQueue;

    }

    public void run() {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("Putting " + i);
            queue.push(new Node(String.valueOf(i)));

        }
    }
}
