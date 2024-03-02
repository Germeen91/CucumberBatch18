package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String read(String key)  { //static polymorphism by overloading
        return read(key, Constants.CONFIG_FILE_PATH);
    }


    //if an exception is thrown within the try block, the catch block will catch it,
    // and e.printStackTrace() will be called to print the stack trace of the exception to the console.
    public static String read(String key, String path)  {

        Properties  properties = new Properties();
        try (FileInputStream fis = new FileInputStream(path))
        {
            properties.load(fis);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return properties.getProperty(key);


    }









    }

