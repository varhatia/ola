package com.varhatia.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by IntelliJ IDEA.
 * User: varhatia
 * Date: 9/1/16
 * Time: 12:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileUtil {

    public static void writeFile(byte[] bytes, String filePath) throws IOException
      {
          File folder = new File(filePath).getParentFile();
          if(!folder.exists())
          {
              folder.mkdirs();
          }

          Files.write(Paths.get(filePath), bytes);

      }

}
