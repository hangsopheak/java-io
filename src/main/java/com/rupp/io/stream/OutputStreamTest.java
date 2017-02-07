package com.rupp.io.stream;

import java.io.File;
import java.io.FileOutputStream;

public class OutputStreamTest {
    
    public static void main(String[] args) {
        final String mycontent = "This is my Data which needs to be written into the filesss";
        
        try (FileOutputStream fos = new FileOutputStream(new File("myfile.txt"));
        ) {
            // write bytes
            byte[] bytesArray = mycontent.getBytes();

            fos.write(bytesArray);
            fos.flush();
            System.out.println("File Written Successfully");
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }

    }
}
