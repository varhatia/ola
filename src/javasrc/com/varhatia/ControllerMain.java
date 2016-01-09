package com.varhatia;

import java.util.Scanner;
/**
 * Created by IntelliJ IDEA.
 * User: varhatia
 * Date: 9/1/16
 * Time: 10:18 AM
 * To change this template use File | Settings | File Templates.
 */

public class ControllerMain
{
    private static Controller controller = null;

    public static void main(String[] args)
    {
        System.out.println("Supported Commands: [start] [stop]");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (input != null)
        {
            if("stop".equalsIgnoreCase(input))
            {
                if(controller != null)
                {
                    controller.stop();
                    System.exit(0);
                }
            }
            else if("start".equalsIgnoreCase(input))
            {
                if(controller != null)
                {
                    System.out.println("Controller already started");
                }
                else
                {
                    controller = new Controller();
                    try
                    {
                        controller.start();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                    System.out.println("Controller Started Successfully ");
                }
                System.out.println("Type 'stop' for stopping the controller");
            }
            input = scanner.nextLine();
        }
    }
}
