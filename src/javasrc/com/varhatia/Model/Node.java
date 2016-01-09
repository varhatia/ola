package com.varhatia.Model;

/**
 * Created by IntelliJ IDEA.
 * User: varhatia
 * Date: 9/1/16
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class Node {

    String value;
    Node prev;
    Node next;

    public Node(String v) {
        this.value = v;
    }

    public String getValue() {
        return value;
    }



}
