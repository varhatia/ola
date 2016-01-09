package com.varhatia.data;

import com.varhatia.ControllerContext;
import com.varhatia.ControllerProperties;
import com.varhatia.utils.FileUtil;
import com.varhatia.Model.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: varhatia
 * Date: 9/1/16
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class DataQueueImpl implements DataQueue {

    private List<Node> nodeList = null;
    private ControllerContext context = null;
    private ControllerProperties properties = null;
    private File storageFile = null;


    public void init(ControllerContext context) {
        this.nodeList = new ArrayList<>();
        this.context = context;
        this.properties = context.getProperties();
        String storageFilePath = properties.getStorageFilesPath();
        this.storageFile = new File(storageFilePath);
        initializeTasks();
    }
    public void initialize() {
        this.nodeList = new ArrayList<>();

    }
    protected void initializeTasks() {


        //read the file line by line and create Node to insert in dll
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(storageFile));

            String line = br.readLine();
            StringBuilder stringBuilder = null;
            while (line!=null)
            {
                stringBuilder = new StringBuilder();
                Node tNode = new Node(String.valueOf(line));
                nodeList.add(tNode);

                stringBuilder.append(Integer.getInteger(line));
                stringBuilder.append('\n');

                line = br.readLine();
            }
            if(stringBuilder!=null)
            {
                FileUtil.writeFile(stringBuilder.toString().getBytes(), storageFile.getPath());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try
            {
                if(br!=null)
                    br.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public synchronized void push(Node node) {
        //add to list
        nodeList.add(node);


        //write to file
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(storageFile));

            String line = br.readLine();
            StringBuilder stringBuilder =  new StringBuilder();;
            while (line != null)
            {
                stringBuilder.append(String.valueOf(line));
                stringBuilder.append('\n');

                line = br.readLine();
            }

            stringBuilder.append(String.valueOf(node.getValue()));
            stringBuilder.append('\n');

            if (stringBuilder != null)
            {
                FileUtil.writeFile(stringBuilder.toString().getBytes(), storageFile.getPath());
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        finally {
            if(br!=null)
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
        }

    }

    public synchronized Node pop() {
        if(nodeList.size()==0)
        {
            return null;
        }

        //update the file
        updateFile();
        return nodeList.remove(0);
    }

    private void updateFile() {
        //write to file
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(storageFile));

            String line = br.readLine();
            line = br.readLine(); //for next line
            StringBuilder stringBuilder = new StringBuilder();

            while (line != null)
            {
                stringBuilder.append(String.valueOf(line));
                stringBuilder.append('\n');

                line = br.readLine();
            }

            if (stringBuilder != null)
            {
                FileUtil.writeFile(stringBuilder.toString().getBytes(), storageFile.getPath());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

        }
    }

    public synchronized Node take(){
        Node node = null;
        boolean noEntry = true;
        int maxTries = 100;
        while (noEntry && maxTries>0)
        {
            if(nodeList.size()!=0)
            {
                noEntry = false;
            }
            maxTries--;
        }

        if(nodeList.size() != 0)
        {
           updateFile();
           node = nodeList.remove(0);

        }
        return node;
    }

    public Node offer() {

        return nodeList.get(0);
    }

    public void printQueue() {

        for(Node node : nodeList)
        {
            System.out.print("Node Data"+node.getValue());
        }
    }
}
