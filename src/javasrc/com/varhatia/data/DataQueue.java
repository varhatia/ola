package com.varhatia.data;

import com.varhatia.ControllerContext;
import com.varhatia.Model.Node;

/**
 * Created by IntelliJ IDEA.
 * User: varhatia
 * Date: 9/1/16
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public interface DataQueue {

    public void init(ControllerContext context);

    public void push(Node node);

    public Node pop();

    public Node take();

    public Node offer();

    void printQueue();
}
