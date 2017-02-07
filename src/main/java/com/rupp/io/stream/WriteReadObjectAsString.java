package com.rupp.io.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class WriteReadObjectAsString {
    
public static void main(String[] args) {
    //write object wirle
    writeObjectOutputStream("object.ser");
    
    //read file object
    readObjectInputSteam("object.ser");
}

    public static void writeObjectOutputStream(String fn) {
        //create file object.ser as OutputStream
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fn)));) {

            out.writeObject("The current Date and Time is "); // write a String object
            out.writeObject(new Date()); // write a Date object
            out.writeObject(100L); // write a Long Object
            out.flush();
            //out.close();
            System.out.println("write object into file " + fn + " successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void readObjectInputSteam(String fn) {
        
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fn)));) {
            String str = (String) in.readObject();
            Date d = (Date) in.readObject();
            Long longValue = (Long)in.readObject();
            
            System.out.println(str);
            System.out.println(d);
            System.out.println(longValue);
            //in.close();
            
        }catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
