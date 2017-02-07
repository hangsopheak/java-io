package com.rupp.io.stream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadStream {
    
    public static void main(String[] args) {
        String data = null;
        try (
                InputStream input = new FileInputStream(new File("file.txt"));
                BufferedInputStream bis = new BufferedInputStream(input);
                
                ) {
            
            //read until a single byte is available
            while(bis.available()>0){
               // read the byte and convert the integer to character
               char c = (char)bis.read();
               data = data + c;
            }
            System.out.println(data);
            
        } catch (IOException ex) {
           
        }
    }
}
