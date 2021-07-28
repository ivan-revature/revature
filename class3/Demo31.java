package com.thevarungupta.Day3;

import java.io.*;

public class Demo31 {
    public static void main(String[] args) {
        // try block to check for exception
        try (FileOutputStream stream = new FileOutputStream("D:\\data.txt"))  // creating an object of fileOutputStream
        {
            // custom string input
            String data = "Hello World";
            // convert string to bytes
            byte[] arr = data.getBytes();
            // text written in the file
            stream.write(arr);
        }
        // catch block to handle exception
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("resource are closed");


    }
}
