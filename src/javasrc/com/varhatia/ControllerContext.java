package com.varhatia;

import com.varhatia.data.DataQueue;

/**
 * Created by IntelliJ IDEA.
 * User: varhatia
 * Date: 9/1/16
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */

public class ControllerContext {
    private ControllerProperties properties = null;
    private DataQueue dataQueue = null;

    public DataQueue getDataQueue() {
        return dataQueue;
    }

    public void setDataQueue(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    public ControllerProperties getProperties() {
        return properties;
    }

    public void setProperties(ControllerProperties properties) {
        this.properties = properties;
    }
}
