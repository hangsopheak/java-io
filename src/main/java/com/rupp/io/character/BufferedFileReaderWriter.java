package com.rupp.io.character;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class BufferedFileReaderWriter {
    public static void main(String[] args) {
        String strFilename = "out.txt";
        String message = "Hello, world!\nHello, world again!\n"; // 2 lines of texts
        Charset defaultCharset = java.nio.charset.Charset.defaultCharset();
        // Print the default charset
        System.out.println(defaultCharset);

        // buffer writer
        try (BufferedWriter out = new BufferedWriter(new FileWriter(strFilename))) {
            out.write(message);
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // buffer reader
        try (BufferedReader in = new BufferedReader(new FileReader(strFilename))) {
            String inLine;
            while ((inLine = in.readLine()) != null) { // exclude newline
                System.out.println(inLine);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
