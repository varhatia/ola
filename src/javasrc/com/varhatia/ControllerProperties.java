package com.varhatia;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ControllerProperties extends Properties
{
	private static final String PROPERTY_FILE = new File("").getAbsolutePath() + "\\controller.properties";

    public static final String STORAGE_FILES_PATH = "TASK_FILES_PATH";

    private Map<String, String> defaultValues = null;

    public static final String DEFAULT_STORAGE_FILE_PATH = "C:\\logFile.txt";

    public ControllerProperties()
    {
        try
        {
            FileInputStream stream = new FileInputStream(PROPERTY_FILE);
            load(stream);
        }
        catch(IOException e)
        {
            System.out.println("Unable to load controller.properties. Will use the default values");
            e.printStackTrace();
        }

        defaultValues = new HashMap<>();

        defaultValues.put(STORAGE_FILES_PATH, DEFAULT_STORAGE_FILE_PATH);
    }

    @Override
    public String getProperty(String key)
    {
        String value = super.getProperty(key);
        if(value == null)
        {
            return defaultValues.get(key);
        }
        return value;
    }

    public String getStorageFilesPath()
    {
        return getProperty(ControllerProperties.STORAGE_FILES_PATH);
    }

}
